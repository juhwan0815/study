package com.redis.study.redis.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

// 캐시키와 유효시간 정보를 저장
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CacheKey {

    public static final int DEFAULT_EXPIRE_SEC = 60;
    public static final String USER = "user";
    public static final int USER_EXPIRE_SEC = 180;

}
