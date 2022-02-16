package com.fontys_automotive.api.project;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fontys_automotive.api.teacher.Teacher;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Table
public class Project {
    @Id
    @SequenceGenerator(
            name = "project_sequence",
            sequenceName = "project_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "project_sequence"
    )

    @JsonIgnore
    private long id;
    private String projectTitle;
    private String projectShortDescription;
    private String projectShortCode;
    private String projectDescription;
    private LocalDate projectStartDate;
    @ManyToMany
    private Set<Teacher> involvedTeachers;


    public Project() {
    }

    public Project(String projectTitle, String projectShortDescription, String projectShortCode, String projectDescription, LocalDate projectStartDate, String bio) {
        this.projectTitle = projectTitle;
        this.projectShortDescription = projectShortDescription;
        this.projectShortCode = projectShortCode;
        this.projectDescription = projectDescription;
        this.projectStartDate = projectStartDate;
    }

    public Project(long id, String projectTitle, String projectShortDescription, String projectShortCode, String projectDescription, LocalDate projectStartDate, String bio) {
        this.id = id;
        this.projectTitle = projectTitle;
        this.projectShortDescription = projectShortDescription;
        this.projectShortCode = projectShortCode;
        this.projectDescription = projectDescription;
        this.projectStartDate = projectStartDate;
    }
}
