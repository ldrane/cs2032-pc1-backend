package com.example.pc1dbp.user.domain;

import com.example.pc1dbp.enrollment.domain.Enrollment;
import com.example.pc1dbp.membership.domain.Membership;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table("users")
@Getter
@Setter
public class User implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;

    @OneToOne(mappedBy="user", cascade=CascadeType.ALL)
    private Membership membership;

    @OneToOne(mappedBy="user", cascade=CascadeType.ALL)
    private Enrollment enrollment;

    public User(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }

    //Falta mas overrides
}
