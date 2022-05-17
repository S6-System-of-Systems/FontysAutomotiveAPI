package com.fontys_automotive.api.tus.models;

public class Institution {
    public String name;

    public Institution(String name, String domainName) {
        this.name = name;
        this.domainName = domainName;
    }

    public String domainName;
}
