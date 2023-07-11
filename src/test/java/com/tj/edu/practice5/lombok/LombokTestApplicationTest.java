package com.tj.edu.practice5.lombok;

import com.tj.edu.practice5.lombok.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import com.tj.edu.practice5.lombok.model.Member;

class LombokTestApplicationTest {

    @BeforeEach
    void setUp() {
    }

    @DisplayName("Lombok 테스트")
    @Test
    void lombokTest() {
        User user = new User();
        user.setName("홍길동");
        user.setEmail("gildong@gmail.com");

        User user2 = new User("김복순", "boksun@abc.com", LocalDateTime.now(), LocalDateTime.now());
        User user3 = new User("짱구", "zzanggu@abc.com");

        System.out.println(user.getName());
        System.out.println(user.getEmail());

        // user builder이용한 user 객체 생성
        // null pointer exception을 방지하는 기능
        User user4 = User.builder()
                .name("홍길동2")
                .email("aaa@asdf.com")
                .createAt(LocalDateTime.now()).build();

        System.out.println("-------------------------------------------------------------");
        System.out.println(user4.getEmail());
        System.out.println(user4.getCreateAt());

        Member member = new Member();
        member.setId(1L);

        System.out.println("-------------------------------------------------------------");
        System.out.println(member.getId());

        Member member2 = Member.builder().age(1).id(1L).build();
        System.out.println("-------------------------------------------------------------");
        System.out.println(member2.getAge());
    }

    @AfterEach
    void tearDown() {
    }
}