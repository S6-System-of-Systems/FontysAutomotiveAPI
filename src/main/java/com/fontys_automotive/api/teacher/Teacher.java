package com.fontys_automotive.api.teacher;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fontys_automotive.api.inzet.Inzet;
import com.fontys_automotive.api.project.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"
    )

    private long id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private int teacherNo;
    private LocalDate dob;
    private String bio;

    //Sharepoint
    @ElementCollection
    private List<String> currentProjects;
    @ElementCollection
    private List<String> ambitions;
    private String goals;
    @Column(columnDefinition = "text")
    private String aboutMe;
    @ElementCollection
    private List<String> responsibilities;
    @ElementCollection
    private List<String> skills;

    //TalentenMarktplaats
    private String overMij;
    private String vraag;
    private String kennis;
    private String projecten;
    private String opleiding;
    private String talenten;
    private String inzet;
    private String functie;
    private String rol;
    private String linkedIn;

    @ElementCollection
    private Set<Inzet> inzetDB;


    public Teacher(String firstName, String lastName, String username, String email, int teacherNo, LocalDate dob, String bio, List<String> currentProjects, List<String> ambitions, String goals, String aboutMe, List<String> responsibilities, List<String> skills, String overMij, String vraag, String kennis, String projecten, String opleiding, String talenten, String inzet, String functie, String rol, String linkedIn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.teacherNo = teacherNo;
        this.dob = dob;
        this.bio = bio;
        this.currentProjects = currentProjects;
        this.ambitions = ambitions;
        this.goals = goals;
        this.aboutMe = aboutMe;
        this.responsibilities = responsibilities;
        this.skills = skills;
        this.overMij = overMij;
        this.vraag = vraag;
        this.kennis = kennis;
        this.projecten = projecten;
        this.opleiding = opleiding;
        this.talenten = talenten;
        this.inzet = inzet;
        this.functie = functie;
        this.rol = rol;
        this.linkedIn = linkedIn;
    }

}
