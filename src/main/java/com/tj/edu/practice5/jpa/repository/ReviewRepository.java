package com.tj.edu.practice5.jpa.repository;

import com.tj.edu.practice5.jpa.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
