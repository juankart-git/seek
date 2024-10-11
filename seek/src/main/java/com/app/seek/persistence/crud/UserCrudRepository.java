package com.app.seek.persistence.crud;

import com.app.seek.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserCrudRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
