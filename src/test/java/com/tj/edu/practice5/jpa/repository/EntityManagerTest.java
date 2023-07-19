package com.tj.edu.practice5.jpa.repository;

import com.tj.edu.practice5.jpa.model.Member;
import com.tj.edu.practice5.jpa.model.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class EntityManagerTest {
    @Autowired
    private EntityManagerFactory emf;
    //    @Autowired
    @PersistenceContext
    private EntityManager em;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Test
    void entityManagerTest() {
        em.createQuery("select u from Member u").getResultList().forEach(s -> System.out.println(s));
        em.createNativeQuery("select * from member");
    }

    @Test
//    @Transactional
    void cacheEntityFindTest() {
//        System.out.println(memberRepository.findByEmail("namsun@thejoeun.com"));
//        System.out.println(memberRepository.findByEmail("namsun@thejoeun.com"));
//        System.out.println(memberRepository.findByEmail("namsun@thejoeun.com"));
//        System.out.println(memberRepository.findById(1L));
//        System.out.println(memberRepository.findById(1L));
//        System.out.println(memberRepository.findById(1L));

        memberRepository.deleteById(1L);
    }

    @Test
    @Transactional
    void cacheEntityFindTest2() {
        Member member = memberRepository.findById(1L).get();
        member.setName("아무개");

//        memberRepository.save(member);
//        memberRepository.flush();
        memberRepository.saveAndFlush(member);
        System.out.println("------------------------------------1");

        member.setEmail("231ssa@sadf.com");
//        memberRepository.save(member);
//        memberRepository.flush();
        memberRepository.saveAndFlush(member);
        System.out.println("------------------------------------2");

        em.flush();
    }

    @Test
//    @Transactional // OSIV (Open Session In View) -> transaction
    void entityManagerTest2() {
        Member member = Member.builder()
                .name("aaaa")
                .email("xzcvz@fdasf.com")
                .build();
        em.persist(member); // jpa 영속성 관리에 저장

        memberRepository.findAll().forEach(System.out::println);
    }

    @Test
    @Transactional
    @Commit
//    @Rollback(false)
    void entityManagerTest3() {
        Users users = Users.builder()
                .name("홍길동10")
                .build();   // 비영속성 상태
//        usersRepository.save(users);
        em.persist(users); // 영속성 상태

        em.detach(users);  // 준영속성 상태
        users.setEmail("ho10@abc.com");
//        em.flush(); // sql실행
//
////        em.clear();
//        em.merge(users); // 준영속성 상태에서 영속성 상태로 변경
//        users.setEmail("ho10----@abc.com");
//        em.remove(users);    // 비영속성으로 삭제 상태

        usersRepository.findAll().forEach(System.out::println);
//        System.out.println(usersRepository.findByName("홍길동10").get(0));
    }

    @Test
    @Transactional
    @Commit
    void persistCacheDelayInsertUpdateTest() {
        Users user = usersRepository.findById(1L).get();    // select, dirty check(변경감지)
        user.setName("이책상1");
        usersRepository.save(user); // select, update

//        user.setEmail("lee1@abc.com");
//        usersRepository.save(user); // select, update
    }
}
