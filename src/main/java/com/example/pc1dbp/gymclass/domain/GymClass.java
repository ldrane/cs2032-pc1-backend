package com.example.pc1dbp.gymclass.domain;

import com.example.pc1dbp.enrollment.domain.Enrollment;
import com.example.pc1dbp.user.domain.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Entity
@Table(name = "gymclass")
@Getter
@Setter
public class GymClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String name;

    private String instructor;

    private String type; //Yoga, Crossfit, Spinning, Boxing, Pilates

    private ZonedDateTime startTime;

    //Tiene que estar en el rango de 30-120
    private Integer durationMin;

    //Tiene que ser mayor o igual a 1
    private Integer capacity;

    //Tiene que ser mayor o igual a 0
    private Integer enrolledCount;

    @OneToOne(mappedBy="gymclass", cascade=CascadeType.ALL)
    private Enrollment enrollment;
}
