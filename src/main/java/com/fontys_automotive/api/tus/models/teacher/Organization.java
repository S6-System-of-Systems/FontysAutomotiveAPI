package com.fontys_automotive.api.tus.models.teacher;

import lombok.Data;

@Data
public class Organization {
    public String name;

    public Organization(String name, String domainName, Address address) {
        this.name = name;
        this.domainName = domainName;
        this.address = address;
    }

    public String domainName;
    public Address address;
}
