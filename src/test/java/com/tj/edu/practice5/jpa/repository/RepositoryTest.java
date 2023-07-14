package com.tj.edu.practice5.jpa.repository;

import com.tj.edu.practice5.jpa.model.Address;
import com.tj.edu.practice5.jpa.model.Book;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class RepositoryTest {

    @Autowired
    private MemberRepository memberRepository;
    //    @Autowired
//    private BoardRepository boardRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AddressRepository addressRepository;

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
        // 1. member데이터 insert(event member log history데이터 insert)
//        memberRepository.save(member)
    }

    @Test
    void bookRepositoryTest() throws InterruptedException {
        Book book = Book.builder()
                .name("표준orm JPA 프로그래밍")
//                .author("김한선")
                .build();
        Book book2 = bookRepository.save(book);

//        Thread.sleep(1000);

//        book2.setAuthor("박봉남");
//        bookRepository.save(book2);
    }

    @Test
    void addressRepositoryTest() throws InterruptedException {
        Address address = Address.builder()
                .zipcode("101-111")
                .build();
        addressRepository.save(address);
    }
    @AfterEach
    void tearDown() {
    }
}