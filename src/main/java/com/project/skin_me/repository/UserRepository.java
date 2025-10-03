package com.project.skin_me.repository;

import com.project.skin_me.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    boolean existsByEmail(String email);

    User findByEmail(String email);
}
