package com.fontys_automotive.api.project;

import com.fontys_automotive.api.teacher.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
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

    private long id;
    private String projectNaam;
    private String projectCode;
    private String taakNaam;
    private String opmerking;
    private String uren;
    private LocalDate projectStartDate;
    private boolean voltooid;
    @ManyToMany
    private Set<Teacher> involvedTeachers;

    public Project(String projectNaam, String taakNaam, String opmerking, String uren, LocalDate projectStartDate, boolean voltooid, Set<Teacher> involvedTeachers) {
        this.projectNaam = projectNaam;
        this.taakNaam = taakNaam;
        this.opmerking = opmerking;
        this.uren = uren;
        this.projectStartDate = projectStartDate;
        this.voltooid = voltooid;
        this.involvedTeachers = involvedTeachers;
    }
}
