package com.fontys_automotive.api.tus.models.project;

public class Address {
    public String line;
    public String country;
    public String region;

    public Address(String line, String country, String region, String city, String postalCode) {
        this.line = line;
        this.country = country;
        this.region = region;
        this.city = city;
        this.postalCode = postalCode;
    }

    public String city;
    public String postalCode;
}
