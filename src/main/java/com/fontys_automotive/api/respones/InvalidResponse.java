package com.fontys_automotive.api.respones;

public class InvalidResponse extends Response {
    String error;

    public InvalidResponse(String error) {
        this.success = false;
        this.error = error;
    }
}
