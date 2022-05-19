package com.fontys_automotive.api.tus.models.teacher;

import lombok.Data;

@Data
public class AttendancePeriod {
    public String start;
    public String end;

    public AttendancePeriod(String start, String end) {
        this.start = start;
        this.end = end;
    }
}
