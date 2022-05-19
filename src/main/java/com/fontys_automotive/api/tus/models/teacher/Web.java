package com.fontys_automotive.api.tus.models.teacher;

import lombok.Data;

@Data
public class Web{
    public Web(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public String url;
    public String name;
}