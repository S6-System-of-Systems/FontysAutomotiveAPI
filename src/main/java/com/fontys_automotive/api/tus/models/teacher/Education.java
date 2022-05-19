package com.fontys_automotive.api.tus.models.teacher;

import lombok.Data;

@Data
public class Education {
    public Institution institution;
    public String title;

    public Education(Institution institution, String title, AttendancePeriod attendancePeriod, String description) {
        this.institution = institution;
        this.title = title;
        this.attendancePeriod = attendancePeriod;
        this.description = description;
    }

    public AttendancePeriod attendancePeriod;
    public String description;
}
