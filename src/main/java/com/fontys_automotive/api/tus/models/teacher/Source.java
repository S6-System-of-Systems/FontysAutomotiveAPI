package com.fontys_automotive.api.tus.models.teacher;

import lombok.Data;

@Data
public class Source {
    public String name;

    public Source(String name, String url, String obtainingDate) {
        this.name = name;
        this.url = url;
        this.obtainingDate = obtainingDate;
    }

    public String url;
    public String obtainingDate;
}
