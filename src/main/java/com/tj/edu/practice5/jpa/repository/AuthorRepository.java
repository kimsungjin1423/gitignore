package com.tj.edu.practice5.jpa.repository;

import com.tj.edu.practice5.jpa.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
