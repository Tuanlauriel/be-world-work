package com.worldwork.beworldwork.repositories;

import com.worldwork.beworldwork.entities.Role;
import com.worldwork.beworldwork.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);

    User findByRole(Role role);

    boolean existsByEmail(String email);
}
