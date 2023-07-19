package com.tj.edu.training.shinsunyoung.controller;

import com.tj.edu.training.shinsunyoung.model.Article;
import com.tj.edu.training.shinsunyoung.model.dto.AddArticleRequest;
import com.tj.edu.training.shinsunyoung.model.dto.ArticleResponse;
import com.tj.edu.training.shinsunyoung.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ArticleApiController {

    private final ArticleService articleService;
    /**
     * Desc: 블로그 글 등록 api
     * @param request
     * @return
     */
    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
        Article savedArticle = articleService.save(request);   // 글 저장

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }

    /**
     * Desc: 블로그 글 목록 api
     * @param
     * @return
     */
    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles() {
        List<Article> articleList = articleService.getArticleAll();

        // stream을 이용한 방식
//        List<ArticleResponse> articleResponseList = articleList.stream()
//                .map(ArticleResponse::new)
//                .toList();
        // 옛날에 쓰던 방식
        List<ArticleResponse> articleResponseList = new ArrayList<>();
        for (Article article : articleList) {
            ArticleResponse articleResponse = new ArticleResponse(article);
            articleResponseList.add(articleResponse);
        }

//        return ResponseEntity.status(HttpStatus.OK)
        return ResponseEntity.ok().body(articleResponseList);
    }

    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable long id){
        Article article = articleService.getArticle(id);

        return ResponseEntity.ok().body(new ArticleResponse(article));
    }

    @DeleteMapping("/api/articles/{id}")
//    public ResponseEntity<Void> deleteArticle(@PathVariable long id) {
    public ResponseEntity<String> deleteArticle(@PathVariable long id) {
        articleService.delete(id);

        return ResponseEntity.ok()
                .body(new String("삭세한 블로그 글 번호id: " + id));
    }
}
