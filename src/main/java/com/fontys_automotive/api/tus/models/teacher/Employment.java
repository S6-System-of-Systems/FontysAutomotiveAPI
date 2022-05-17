package com.fontys_automotive.api.tus.models.teacher;

public class Employment {
    public Organization organization;
    public String title;

    public Employment(Organization organization, String title, String start, String description) {
        this.organization = organization;
        this.title = title;
        this.start = start;
        this.description = description;
    }

    public String start;
    public String description;
}
