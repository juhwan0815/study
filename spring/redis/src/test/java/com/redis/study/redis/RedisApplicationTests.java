package com.redis.study.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.*;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.list;

@SpringBootTest
class RedisApplicationTests {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Test
    public void commonCommand(){
        ValueOperations<String, String> valueOps = redisTemplate.opsForValue();
        valueOps.set("key1","key1value");
        valueOps.set("key2","key2value");
        // Key 타입 조회
        assertThat(redisTemplate.type("key1")).isEqualTo(DataType.STRING);

        // 존재하는 Key의 개수를 반환.
        assertThat(redisTemplate.countExistingKeys(Arrays.asList("key1","key2","key3"))).isEqualTo(2L);

        // Key가 존재하는지 확인
        assertThat(redisTemplate.hasKey("key1")).isTrue();

        // Key 만료 날짜 세팅
        assertThat(redisTemplate.expireAt("key1", Date.from(LocalDateTime.now()
                                .plusDays(1L).atZone(ZoneId.systemDefault()).toInstant()))).isTrue();

        // Key 만료 시간 세팅
        assertThat(redisTemplate.expire("key1",60, TimeUnit.SECONDS)).isTrue();

        // Key 만료 시간 조회
        assertThat(redisTemplate.getExpire("key1")).isGreaterThan(0L);

        // Key 만료 시간 해제
        assertThat(redisTemplate.persist("key1")).isTrue();

        // Key 만료시간이 세팅 안되어 있는 경우 -1 반환
        assertThat(redisTemplate.getExpire("key1")).isEqualTo(-1L);

        // Key 삭제
        assertThat(redisTemplate.delete("key1")).isTrue();

        // Key 일괄 삭제
        assertThat(redisTemplate.delete(Arrays.asList("key1","key2","key3")));
    }

    @Test
    public void opsValue() {
        ValueOperations<String, String> valueOps = redisTemplate.opsForValue();
        Collection<String> cacheKeys = new ArrayList<>();
        String cacheKey = "value_";

        for (int i = 0; i < 10; i++) {
            cacheKeys.add(cacheKey + i);
            valueOps.set(cacheKey + i, String.valueOf(i), 60, TimeUnit.SECONDS);
        }

        List<String> values = valueOps.multiGet(cacheKeys);

        assertThat(values).isNotNull();
        assertThat(values.size()).isEqualTo(10);
    }

    @Test
    public void opsList(){
        ListOperations<String, String> listOps = redisTemplate.opsForList();
        String cacheKey = "valueList";
        for(int i = 0; i < 10; i++){
            listOps.leftPush(cacheKey,String.valueOf(i));
        }

        assertThat(redisTemplate.type(cacheKey)).isEqualTo(DataType.LIST);
        assertThat(listOps.size(cacheKey)).isEqualTo(10L);

        List<String> range = listOps.range(cacheKey, 0, 10);
        for (String s : range) {
            System.out.print(s);
        }

        assertThat(listOps.rightPop(cacheKey)).isEqualTo("0");
        assertThat(listOps.leftPop(cacheKey)).isEqualTo("9");
        assertThat(redisTemplate.delete(cacheKey)).isTrue();
    }

    @Test
    public void opsHash(){
        HashOperations<String, String, String> hashOps = redisTemplate.opsForHash();
        String cacheKey = "valueHash";
        for(int i = 0; i < 10; i++) {
            hashOps.put(cacheKey,"key_" + i, "value_" + i);
        }

        assertThat(redisTemplate.type(cacheKey)).isEqualTo(DataType.HASH);
        assertThat(hashOps.size(cacheKey)).isEqualTo(10L);
        Set<String> hKeys = hashOps.keys(cacheKey);
        for (String hKey : hKeys) {
            System.out.println(hKey + " / " + hashOps.get(cacheKey,hKey));
        }

        assertThat(hashOps.get(cacheKey,"key_5")).isEqualTo("value_5");
        assertThat(hashOps.delete(cacheKey,"key_5")).isEqualTo(1L);
        assertThat(hashOps.get(cacheKey,"key_5")).isNull();
    }

    @Test
    public void opsSet(){
        SetOperations<String, String> setOps = redisTemplate.opsForSet();
        String cacheKey = "valueSet";
        for(int i = 0; i < 10; i++){
            setOps.add(cacheKey,String.valueOf(i));
        }

        assertThat(redisTemplate.type(cacheKey)).isEqualTo(DataType.SET);
        assertThat(setOps.size(cacheKey)).isEqualTo(10L);
        Set<String> members = setOps.members(cacheKey);
        for (String member : members) {
            System.out.print(member + " ");
        }
        assertThat(setOps.isMember(cacheKey,"5")).isTrue();
    }

    @Test
    public void opsSortedSet(){
        ZSetOperations<String, String> zSetOps = redisTemplate.opsForZSet();
        String cacheKey = "valueZSet";

        for(int i = 0; i < 10; i++){
            zSetOps.add(cacheKey,String.valueOf(i),i);
        }

        assertThat(redisTemplate.type(cacheKey)).isEqualTo(DataType.ZSET);
        assertThat(zSetOps.size(cacheKey)).isEqualTo(10L);
        Set<String> range = zSetOps.range(cacheKey, 0, 10);
        for (String s : range) {
            System.out.print(s + " ");
        }

        assertThat(zSetOps.reverseRank(cacheKey,"9")).isEqualTo(0L);
    }

    @Test
    public void OpsGeo(){
        GeoOperations<String, String> geoOps = redisTemplate.opsForGeo();
        String[] cities = {"서울","부산"};
        String[][] gu = {{"강남구","서초구","관악구","동작구","마포구"},{"사하구","해운대구","영도구","동래구","수영구"}};
        Point[][] pointGu = {
                {new Point(10,-10),new Point(11,-20),new Point(13,10),
                new Point(14,30), new Point(15,40)},{new Point(-100,10),
                new Point(-110,20),new Point(-130,80),new Point(-140,60),
                new Point(-150,30)}
        };
        String cacheKey = "valueGeo";

        // previous key delete
        redisTemplate.delete(cacheKey);

        for(int x = 0; x < cities.length ; x++){
            for(int y = 0; y < 5; y++){
                geoOps.add(cacheKey,pointGu[x][y],gu[x][y]);
            }
        }

        Distance distance = geoOps.distance(cacheKey, "강남구", "동작구");
        assertThat(distance).isNotNull();
        assertThat(distance.getValue()).isEqualTo(4469610.0767);
        System.out.println("Distance : " + distance.getValue());
        List<Point> position = geoOps.position(cacheKey, "동작구");
        assertThat(position).isNotNull();

        for (Point point : position) {
            assertThat(14.000001847743988d).isEqualTo(point.getX());
            assertThat(30.000000249977013d).isEqualTo(point.getY());
            System.out.println("Position : " + point.getY() + " X "+ point.getY());
        }
    }

    @Test
    public void opsHyperLogLog(){
        HyperLogLogOperations<String, String> hyperLogLogOps = redisTemplate.opsForHyperLogLog();
        String cacheKey = "valueHyperLogLog";
        String[] arr1 = {"1","2","2","3","4","5","5","5","5","5","6","7","7","7"};
        hyperLogLogOps.add(cacheKey,arr1);
        System.out.println(hyperLogLogOps.size(cacheKey));
        redisTemplate.delete(cacheKey);
    }

    @Test
    void contextLoads() {
    }

}
