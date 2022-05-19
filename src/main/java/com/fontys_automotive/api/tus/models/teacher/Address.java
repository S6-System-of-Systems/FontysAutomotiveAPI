package com.fontys_automotive.api.tus.models.teacher;

import lombok.Data;

@Data
public class Address {
    public String country;
    public String city;
    public String formattedAddress;

    public Address(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public Address(String country, String city) {
        this.country = country;
        this.city = city;

    }


}
