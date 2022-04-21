package com.fontys_automotive.api.inzet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Inzet {
    @Id
    @SequenceGenerator(
            name = "inzet_sequence",
            sequenceName = "inzet_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "inzet_sequence"
    )

    private Long id;
    private String projectNaam;
    private String opmerkingen;
    private int aantalUren;
    private String title;
    @Column(columnDefinition = "text")
    private String content;
    @Column(columnDefinition = "text")
    private String learningOutcomes;
    @Column(columnDefinition = "text")
    private String learningActivities;
}
