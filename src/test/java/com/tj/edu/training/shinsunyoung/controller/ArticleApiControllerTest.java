package com.tj.edu.training.shinsunyoung.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tj.edu.training.shinsunyoung.model.Article;
import com.tj.edu.training.shinsunyoung.model.dto.AddArticleRequest;
import com.tj.edu.training.shinsunyoung.repository.ArticleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ArticleApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ObjectMapper om;

    @BeforeEach
    public void mockMvcSetUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
    }

    @Order(3)
    @DisplayName("addArticle: 블로그 글 추가에 성공한다.")
    @Test
    void addArticle()
            throws Exception
    {
        // 1. given
        final String url = "/api/articles";
        final String title = "제목";
        final String content = "내용";
//        final AddArticleRequest userRequest = new AddArticleRequest(title, content);
        final AddArticleRequest userRequest = AddArticleRequest.builder()
                .title(title)
                .content(content)
                .build();
        final String requestBody = om.writeValueAsString(userRequest);  // java class를 json string형태로 바꾸어줌

        // 2. when (postman에서 post api를 호출한 것과 같은 효과)
        ResultActions resultAction = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)  // request data를 json으로 받겠다.
                .content(requestBody));  // request data -> 여기서는 AddArticleRequest

        // 3. then
        resultAction.andExpect(status().isCreated());

        List<Article> articles = articleRepository.findAll();
        assertThat(articles.size()).isEqualTo(6);
        assertThat(articles.get(5).getTitle()).isEqualTo(title);
        assertThat(articles.get(5).getContent()).isEqualTo(content);
    }

    @Order(1)
    @DisplayName("findAllArticles: 블로그 글 목록 조회에 성공한다.")
    @Test
    public void findAllArticles() throws Exception {
// given
        final String url = "/api/articles";
        final String title = "title";
        final String content = "content";

        articleRepository.save(Article.builder()
                .title(title)
                .content(content)
                .build());          // id가 4인 데이터가 들어감

        // when
        final ResultActions resultActions = mockMvc.perform(get(url)
                .accept(MediaType.APPLICATION_JSON));

        // then
        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[3].content").value(content))
                .andExpect(jsonPath("$[3].title").value(title));
    }

    @Order(2)
    @DisplayName("findArticle: 블로그 글 조회에 성공한다.")
    @Test
    public void findArticle() throws Exception {
        // given
        final String url = "/api/articles/{id}";
        final String title = "title";
        final String content = "content";

        Article savedArticle = articleRepository.save(Article.builder()
                .title(title)
                .content(content)
                .build());

        // when
        final ResultActions resultActions = mockMvc.perform(get(url, savedArticle.getId()));

        // then
        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value(content))
                .andExpect(jsonPath("$.title").value(title));
    }
}