package com.tj.edu.practice5.jpa.repository;

import com.tj.edu.practice5.jpa.model.Board;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RepositoryTest {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private BoardRepository boardRepository;

    @BeforeEach
    void setUp() {
    }

    @DisplayName("간단한 jpa테스트1")
    @Test
    void jpaTest1() {

    }

    @DisplayName("간단한 JPA MemberRepository 테스트")
    @Test
    void memberRepositoryTest1() {

    }
    @DisplayName("간단한 JPA BoardRepository 테스트")
    @Test
    void boardRepositoryTest1() {
        Board board1 = Board.builder()
                .boardNo("1")
                .imgNo("1")
                .boardKind("질문과답")
                .title("여긴 뭐하는 게시판인가요?")
                .build();
        boardRepository.save(board1);

        Board board2 = Board.builder()
                .boardNo("2")
                .imgNo("1")
                .boardKind("질문과답")
                .title("이거 뭔지 모르겠어요")
                .build();
        boardRepository.save(board2);

        List<Board> boardList = boardRepository.findAllById(Lists.newArrayList("1"));
        boardList.forEach(System.out::println);
    }
    @AfterEach
    void tearDown() {
    }
}