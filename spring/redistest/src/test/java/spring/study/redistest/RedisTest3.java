package spring.study.redistest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.study.redistest.domain.Point;
import spring.study.redistest.domain.PointRedisRepository;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RedisTest3 {

    @Autowired
    private PointRedisRepository pointRedisRepository;

    @AfterEach
    public void teatDown(){
        pointRedisRepository.deleteAll();
    }

    @Test
    void 기본_등록_조회기능(){
        // given
        String id = "juhwan";
        LocalDateTime refreshTime = LocalDateTime.of(2021, 10, 19, 0, 0);
        Point point = Point.builder()
                .id(id)
                .amount(1000L)
                .refreshTime(refreshTime)
                .build();

        // when
        pointRedisRepository.save(point);

        // then
        Point savedPoint = pointRedisRepository.findById(id).get();
        assertThat(savedPoint.getAmount()).isEqualTo(1000L);
        assertThat(savedPoint.getRefreshTime()).isEqualTo(refreshTime);
    }

    @Test
    public void 수정기능(){
        // given
        String id = "juhwan";
        LocalDateTime refreshTime = LocalDateTime.of(2021, 10, 19, 0, 0 );
        Point point = Point.builder()
                .id(id)
                .amount(1000L)
                .refreshTime(refreshTime)
                .build();

        pointRedisRepository.save(point);

        // when
        Point savedPoint = pointRedisRepository.findById(id).get();
        savedPoint.refresh(2000L,LocalDateTime.of(2021,10,19,1,0,0));
        pointRedisRepository.save(savedPoint);

        // then
        Point refreshPoint = pointRedisRepository.findById(id).get();
        assertThat(refreshPoint.getAmount()).isEqualTo(2000L);
    }

}
