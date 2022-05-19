package com.fontys_automotive.api.tus.models.project;

import lombok.Data;

@Data
public class Location{
    public Address address;

    public Location(Address address) {
        this.address = address;
    }
}
