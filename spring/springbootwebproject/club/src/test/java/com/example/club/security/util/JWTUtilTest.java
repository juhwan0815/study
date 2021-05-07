package com.example.club.security.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JWTUtilTest {


    private JWTUtil jwtUtil;

    @BeforeEach
    public void testBefore(){
        System.out.println("testBefore........");
        jwtUtil = new JWTUtil();
    }

    @Test
    void testEncode() throws Exception{
        String email = "user95@naver.com";

        String str = jwtUtil.generateToken(email);

        System.out.println(str);
    }

    @Test
    void testValidate() throws Exception{
        String email = "user95@naver.com";

        String str = jwtUtil.generateToken(email);

        Thread.sleep(5000);

        String resultEmail = jwtUtil.validateAndExtract(str);

        System.out.println(resultEmail);
    }
}