package com.tj.edu.practice5.jpa.repository;

import com.tj.edu.practice5.jpa.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, String> {

}
