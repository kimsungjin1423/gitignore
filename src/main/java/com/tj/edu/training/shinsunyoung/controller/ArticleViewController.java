package com.tj.edu.training.shinsunyoung.controller;

import com.tj.edu.training.shinsunyoung.model.dto.ArticleListViewResponse;
import com.tj.edu.training.shinsunyoung.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ArticleViewController {

    private final ArticleService articleService;

    @GetMapping("/articles")
    public String getArticles(Model model) {

        List<ArticleListViewResponse> articleResponseList = articleService.getArticleAll().stream()
                .map(ArticleListViewResponse::new)
                .toList();
        model.addAttribute("articles", articleResponseList);

//        model.addAttribute("articles", articleService.getArticleAll());

        return "articleList";
    }

    @GetMapping("/new-article")
    public String newArticles(Model model) {

        return "newArticle";
    }
}
