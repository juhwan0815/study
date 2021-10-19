package spring.study.redis.pubsub;

import lombok.*;

import java.io.Serializable;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoomMessage implements Serializable {

    private String roomId;

    private String name;

    private String message;
}


