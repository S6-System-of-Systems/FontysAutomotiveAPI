package com.fontys_automotive.api.tus.models.teacher;

import lombok.Data;

@Data
public class Language {
    public Language(String language, String proficiency) {
        this.language = language;
        this.proficiency = proficiency;
    }

    public String language;
    public String proficiency;
}
