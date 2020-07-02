package com.demo.dto;

import java.util.HashMap;
import java.util.Map;

public class ResponseDto {

    private boolean status;
    private String message;
    private Map<String, Object> extra = new HashMap<>();

    public ResponseDto() {

    }

    public ResponseDto(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    public void setExtra(Map<String, Object> extra) {
        this.extra = extra;
    }
}
