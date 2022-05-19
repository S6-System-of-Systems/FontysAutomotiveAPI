package com.fontys_automotive.api.tus.models.teacher;

import lombok.Data;

@Data
public class Name {
    public String formattedName;

    public Name(String formattedName) {
        this.formattedName = formattedName;
    }
}
