package com.optimagrowth.license.model.utils;

import lombok.Data;

@Data
public class ErrorMessage {

    private String message;

    private String code;

    private String detail;

    public ErrorMessage(String message, String code, String detail) {
        this.message = message;
        this.code = code;
        this.detail = detail;
    }

    public ErrorMessage(String message, String detail) {
        this.message = message;
        this.detail = detail;
    }

    public ErrorMessage(String message) {
        this.code = "";
        this.detail = "";
        this.message = message;
    }
}
