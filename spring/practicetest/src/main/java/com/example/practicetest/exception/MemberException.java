package com.example.practicetest.exception;

public class MemberException extends RuntimeException{

    public MemberException() {
        super();
    }

    public MemberException(String message) {
        super(message);
    }

    public MemberException(Throwable cause) {
        super(cause);
    }
}
