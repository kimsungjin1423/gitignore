package com.tj.edu.practice5.jpa.repository;

import com.tj.edu.practice5.jpa.model.Member;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@SpringBootTest
public class JpaQueryMethodTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    void jpaQueryMethodTest1 () {
        // SELECT문: email값으로 특정 row데이터 가져오기
        Set<Member> memberLeesunsins = memberRepository.readByEmail("leesunsin@gmail.com");
        memberLeesunsins.forEach(System.out::println);
//        System.out.println(memberLeesunsins);

        // SELECT문: name값으로 특정 row데이터 가져오기
        List<Member> memberHongildongList = memberRepository.findByName("홍길동");
//        memberHongildongList.forEach(System.out::println);
        System.out.println(memberHongildongList);

//        Optional<Member> memberOpt1 = memberRepository.findByCreateAt(LocalDateTime.MAX);
//        System.out.println(memberOpt1);

        System.out.println("findByName: " + memberRepository.findByName("이순신"));
        System.out.println("queryByName: " + memberRepository.queryByName("이순신"));
        System.out.println("searchByName: " + memberRepository.searchByName("이순신"));
        System.out.println("streamByName: " + memberRepository.streamByName("이순신"));
        System.out.println("getByName: " + memberRepository.getByName("이순신"));
//        System.out.println("getByByName: " + memberRepository.getByByName("이순신"));  // error
        System.out.println("findMemberByName: " + memberRepository.findMemberByName("이순신"));
        System.out.println("findSomethingByName: " + memberRepository.findSomethingByName("이순신"));

        System.out.println("getByName: " + memberRepository.getByName("이순신"));
//        System.out.println("findByImgNo: " + memberRepository.findByImgNo("1"));  // error(img_no컬럼이 entity구성에 없기 때문

        // exists...by, count...by 쿼리 메소드 만들어보기

        // topNumber, firstNumber, lastNumber, distinct
//        memberRepository.findFirst1ByEmail("namsun@thejoeun.com").forEach(System.out::println);
//        memberRepository.findTop1ByEmail("namsun@thejoeun.com").forEach(System.out::println);
//        memberRepository.findTop2ByEmail("namsun@thejoeun.com").forEach(System.out::println);
//        memberRepository.findLast1ByEmail("namsun@thejoeun.com").forEach(System.out::println);    // last적용안됨
//        memberRepository.findLast2ByEmail("namsun@thejoeun.com").forEach(System.out::println);      // last적용안됨
//        memberRepository.findDistinctByEmail("namsun@thejoeun.com").forEach(System.out::println);
        memberRepository.findDistinctByEmail("namsun@thejoeun.com").forEach(s -> System.out.println(s));
    }

    @Test
    void jpaQueryMethodTest2 () {
//        List<Member> memberList = memberRepository.findByNameAndEmail("홍길동", "mars@thejoeun.com");
//        memberList.forEach(s -> System.out.println(s));
//
//        List<Member> memberList2 = memberRepository.findByNameOrEmail("박남순", "mars@thejoeun.com");
//        memberList2.forEach(s -> System.out.println(s));

//        List<Member> memberList3 = memberRepository.findByCreateAtAfter(LocalDateTime.now().minusDays(1L));
//        memberList3.forEach(s -> System.out.println(s));

//        List<Member> memberList4 = memberRepository.findByCreateAtIsAfter(LocalDateTime.now().minusDays(1L));
//        memberList4.forEach(s -> System.out.println(s));

//        List<Member> memberList5 = memberRepository.findByCreateAtGreaterThan(LocalDateTime.now().minusDays(1L));
//        memberList5.forEach(s -> System.out.println(s));
//
//        List<Member> memberList6 = memberRepository.findByCreateAtGreaterThanEqual(LocalDateTime.now().minusDays(1L));
//        memberList6.forEach(s -> System.out.println(s));

//        List<Member> memberList5 = memberRepository.findByIdGreaterThanEqual(3L);
//        memberList5.forEach(s -> System.out.println(s));

//        List<Member> memberList6 = memberRepository.findByCreateAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(1L));
//        memberList6.forEach(s -> System.out.println(s));

//        List<Member> memberList7 = memberRepository.findByNameLike("%홍%");
//        memberList7.forEach(s -> System.out.println(s));

//        List<Member> memberList8 = memberRepository.findByNameIn(Lists.newArrayList("홍길동", "강감찬"));
//        memberList8.forEach(s -> System.out.println(s));

//        List<Member> memberList9 = memberRepository.findByNameContains("강");
//        memberList9.forEach(s -> System.out.println(s));

//        List<Member> memberList10 = memberRepository.findByNameOrderByIdDesc("홍길동");
//        memberList10.forEach(s -> System.out.println(s));

//        List<Member> memberList11 = memberRepository.findByAddressIsNotEmpty();
//        memberList11.forEach(s -> System.out.println(s));

//        List<Member> memberList12 = memberRepository.findByMaleIsFalse();
//        memberList12.forEach(s -> System.out.println(s));

        Page<Member> pageMember = memberRepository.findByName("홍길동", PageRequest.of(0, 3, Sort.by(Sort.Order.desc("id"), Sort.Order.asc("email"))));
        List<Member> memberList13 = pageMember.getContent();
        memberList13.forEach(System.out::println);
    }
}
