package com.fontys_automotive.api.tus.models.project;

public class Position{
    public Function function;
    public Location location;
    public String description;

    public Position(Function function, Location location, String descr) {
        this.function = function;
        this.location = location;
        this.description = descr;
    }


}