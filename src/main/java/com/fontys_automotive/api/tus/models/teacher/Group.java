package com.fontys_automotive.api.tus.models.teacher;

import lombok.Data;

@Data
public class Group {
    public String url;
    public String name;

    public Group(String url, String name) {
        this.url = url;
        this.name = name;
    }
}
