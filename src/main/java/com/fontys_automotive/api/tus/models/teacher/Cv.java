package com.fontys_automotive.api.tus.models.teacher;

public class Cv {
    public String id;
    public Person person;
    public Profile profile;

    public Cv(String id, Person person, Profile profile) {
        this.id = id;
        this.person = person;
        this.profile = profile;
    }


}
