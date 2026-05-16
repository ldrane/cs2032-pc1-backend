package com.example.pc1dbp.enrollment.domain;

import com.example.pc1dbp.gymclass.domain.GymClass;
import com.example.pc1dbp.user.domain.User;
import jakarta.persistence.*;

import javax.annotation.processing.Generated;
import java.time.ZonedDateTime;

public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne
    @JoinColumn(name="user_id", referencedColumnName = "id", nullable=false)
    private User user;


    @OneToOne
    @JoinColumn(name="class_id", referencedColumnName = "id", nullable=false)
    private GymClass gymclass;

    private ZonedDateTime enrolledAt;
    private String status; //Puede ser Reserved, Attened, Cancelled, NO-SHOW
}
