package com.tj.edu.practice5.jpa.repository;

import com.tj.edu.practice5.jpa.model.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface MemberRepository extends JpaRepository<Member, Long> {
   //    Member findByEmail(String email);
//    Member findByName(String name);
   Set<Member> readByEmail(String email);

   List<Member> findByName(String name);

   Page<Member> findByName(String name, Pageable pageable);

   List<Member> findByNameIs(String name);

   List<Member> findByNameEquals(String name);

   List<Member> getByName(String name);

   List<Member> findMemberByName(String name);

   List<Member> findSomethingByName(String name);

   List<Member> searchByName(String name);

   List<Member> queryByName(String name);

   //    List<Member> getByByName(String name);    // error
   List<Member> streamByName(String name);
//    List<Member> findByImgNo(String name);      // error

   Optional<Member> findByCreateAt(LocalDateTime localDataTime);

   List<Member> findTop1ByEmail(String email);

   List<Member> findFirst1ByEmail(String email);

   List<Member> findTop2ByEmail(String email);

   List<Member> findLast1ByEmail(String email);

   List<Member> findLast2ByEmail(String email);

   List<Member> findDistinctByEmail(String email);

   List<Member> findByNameAndEmail(String name, String email);

   List<Member> findByNameOrEmail(String name, String email);

   List<Member> findByCreateAtAfter(LocalDateTime yesterday);

   List<Member> findByCreateAtIsAfter(LocalDateTime yesterday);

   List<Member> findByCreateAtGreaterThan(LocalDateTime yesterday);

   List<Member> findByCreateAtGreaterThanEqual(LocalDateTime yesterday);

   List<Member> findByIdGreaterThanEqual(Long id);

   List<Member> findByCreateAtBetween(LocalDateTime yesterday, LocalDateTime tomorrow);

   List<Member> findByIdGreaterThanEqualAndIdLessThanEqual(Long id1, Long id2);

   List<Member> findByEmailIsNotNull();

   List<Member> findByNameLike(String likeName);

   List<Member> findByNameIn(List<String> nameList);

   List<Member> findByNameContains(String name);

   List<Member> findByNameStartingWith(String name);

   List<Member> findByNameEndingWith(String name);

   List<Member> findByNameOrderByName(String name);

   List<Member> findByNameOrderByIdDesc(String name);

   List<Member> findByAddressIsEmpty();

   List<Member> findByAddressIsNotEmpty();

   List<Member> findByMaleIsFalse();
}

