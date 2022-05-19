package com.fontys_automotive.api.tus.models.project;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Classification{
    @JsonProperty("function_id")
    public int functionId;
    @JsonProperty("function_id")
    public int typeId;
    @JsonProperty("type_label")
    public String typeLabel;
    @JsonProperty("category_id")
    public int categoryId;
    @JsonProperty("category_label")
    public String categoryLabel;
    @JsonProperty("full_match")
    public boolean fullMatch;
    public int level;

    public Classification(int functionId, int typeId, String typeLabel, int categoryId, String categoryLabel, boolean fullMatch, int level) {
        this.functionId = functionId;
        this.typeId = typeId;
        this.typeLabel = typeLabel;
        this.categoryId = categoryId;
        this.categoryLabel = categoryLabel;
        this.fullMatch = fullMatch;
        this.level = level;
    }
}
