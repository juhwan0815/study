package spring.study.redis.pubsub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@Service
public class RedisPublisher {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    public void publish(ChannelTopic topic,RoomMessage message){
        redisTemplate.convertAndSend(topic.getTopic(),message);
    }
}
