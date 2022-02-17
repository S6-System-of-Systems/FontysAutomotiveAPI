package com.fontys_automotive.api.teacher;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fontys_automotive.api.project.Project;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table
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
    private String email;
    private int teacherNo;
    private LocalDate dob;
    private String bio;


    public Teacher(long id,
                   String firstName,
                   String lastName,
                   String email,
                   int teacherNo,
                   LocalDate dob,
                   String bio) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.teacherNo = teacherNo;
        this.dob = dob;
        this.bio = bio;
    }

    public Teacher() {
    }

    public Teacher(String firstName,
                   String lastName,
                   String email,
                   int teacherNo,
                   LocalDate dob,
                   String bio) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.teacherNo = teacherNo;
        this.dob = dob;
        this.bio = bio;
    }
}
