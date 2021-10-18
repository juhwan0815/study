package com.redis.study.redis.pubsub;

import lombok.*;

import java.io.Serializable;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoomMessage implements Serializable {

    private static final long serialVersionUID = 825031192322391880L;

    private String roomId;

    private String name;

    private String message;
}
