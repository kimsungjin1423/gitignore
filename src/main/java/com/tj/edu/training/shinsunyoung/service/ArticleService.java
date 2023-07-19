package com.tj.edu.training.shinsunyoung.service;

import com.tj.edu.training.shinsunyoung.model.Article;
import com.tj.edu.training.shinsunyoung.model.dto.AddArticleRequest;
import com.tj.edu.training.shinsunyoung.model.dto.UpdateArticleRequest;
import com.tj.edu.training.shinsunyoung.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    // 블로그 글 저장
    public Article save(AddArticleRequest addArticleRequest) {
        return articleRepository.save(addArticleRequest.toEntity());
    }

    // 블로그 글 목록 가져오기
    public List<Article> getArticleAll() {
        return articleRepository.findAll();
    }

    // 블로그 글 상세정보 가져오기
    public Article getArticle(long articleId) {
        return articleRepository.findById(articleId).orElseThrow(
                () -> new IllegalArgumentException("not found : " + articleId)
        );
    }

    // 블로그 글 삭제하기
    public void delete(long id) {
        articleRepository.deleteById(id);
    }

    // 블로그 글 수정하기
    @Transactional
    public Article update(long articleId, UpdateArticleRequest updateArticleRequest) {

        Article article = articleRepository.findById(articleId).orElseThrow(
                () -> new IllegalArgumentException("not found : " + articleId));

        // @Transactional 필요없는 코드
//        article.setTitle(updateArticleRequest.getTitle());
//        article.setContent(updateArticleRequest.getContent());
//        return articleRepository.save(article);    // update

        article.update(updateArticleRequest.getTitle(), updateArticleRequest.getContent());
        return article;
    }
}
