package com.fontys_automotive.api.respones;

public class ValidResponse extends Response{
    Object responseObject;

    public ValidResponse(Object responseObject) {
        this.success = true;
        this.responseObject = responseObject;
    }
}
