package com.fontys_automotive.api.tus.models.teacher;

import java.util.ArrayList;

public class Profile{
    public String languageCode;
    public Source source;

    public Profile(String languageCode, Source source, ArrayList<String> qualifications, ArrayList<String> hobbies, ArrayList<Language> languages, ArrayList<Group> groups, String additional_information) {
        this.languageCode = languageCode;
        this.source = source;
        this.qualifications = qualifications;
        this.hobbies = hobbies;
        this.languages = languages;
        this.groups = groups;
        this.additional_information = additional_information;
    }

    public ArrayList<String> qualifications;
    public ArrayList<String> hobbies;
    public ArrayList<Language> languages;
    public ArrayList<Group> groups;
    public String additional_information;
}