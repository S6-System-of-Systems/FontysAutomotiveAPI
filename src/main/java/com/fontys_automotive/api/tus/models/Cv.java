package com.fontys_automotive.api.tus;

import com.fontys_automotive.api.tus.models.Person;
import com.fontys_automotive.api.tus.models.Profile;

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
