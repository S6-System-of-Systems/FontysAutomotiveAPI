package com.fontys_automotive.api.project;

import com.fontys_automotive.api.teacher.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
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

    @EmbeddedId
    private MyKey myKey;

//    private String vakCode;
//    private String rol;
    private String beschrijving;
    private String url;


    @Embeddable
    public class MyKey implements Serializable {

        @Column(name = "vakCode", nullable = false)
        private String vakCode;

        @Column(name = "rol", nullable = true)
        private String rol;
    }
}
