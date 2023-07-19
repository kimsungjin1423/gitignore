package com.tj.edu.training.shinsunyoung.repository;

import com.tj.edu.training.shinsunyoung.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
