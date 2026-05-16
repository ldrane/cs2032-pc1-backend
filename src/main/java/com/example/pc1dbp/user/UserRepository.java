package com.example.pc1dbp.user;

import com.example.pc1dbp.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {
}
