package com.example.practicetest.model.member;

import lombok.Data;

@Data
public class MemberSaveRequest {

    private String email;

    private String password;

    private String name;

    private String phoneNumber;
}
