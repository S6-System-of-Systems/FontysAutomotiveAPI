package com.fontys_automotive.api.tus.models.teacher;

import lombok.Data;

@Data
public class Institution {
    public String name;

    public Institution(String name, String domainName) {
        this.name = name;
        this.domainName = domainName;
    }

    public String domainName;
}
