package com.example.pc1dbp.membership.domain;

import com.example.pc1dbp.user.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="user_id", referencedColumnName = "id", nullable=false)
    private User user;

    private String plan;//Puede ser BASIC, PRO o PREMIUM
    private LocalDate startDate;
    private LocalDate endDate;

    private String status; //Active, Expired, Cancelled
}
