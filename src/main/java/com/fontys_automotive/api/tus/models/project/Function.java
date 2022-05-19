package com.fontys_automotive.api.tus.models.project;

import java.util.ArrayList;

public class Function{
    public String title;
    public String level_modifier;
    public ArrayList<Classification> classifications;

    public Function(String title, String level_modifier, ArrayList<Classification> classifications) {
        this.title = title;
        this.level_modifier = level_modifier;
        this.classifications = classifications;
    }
}
