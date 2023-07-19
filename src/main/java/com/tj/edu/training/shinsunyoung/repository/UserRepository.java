package com.tj.edu.training.shinsunyoung.repository;

import com.tj.edu.training.shinsunyoung.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
