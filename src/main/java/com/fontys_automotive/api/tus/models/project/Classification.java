package com.fontys_automotive.api.tus.models.project;

public class Classification{
    public int function_id;
    public int type_id;
    public String type_label;
    public int category_id;
    public String category_label;
    public boolean full_match;
    public int level;

    public Classification(int function_id, int type_id, String type_label, int category_id, String category_label, boolean full_match, int level) {
        this.function_id = function_id;
        this.type_id = type_id;
        this.type_label = type_label;
        this.category_id = category_id;
        this.category_label = category_label;
        this.full_match = full_match;
        this.level = level;
    }
}
