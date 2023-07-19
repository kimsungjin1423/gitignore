package com.tj.edu.practice5.jpa.repository;

import com.tj.edu.practice5.jpa.model.Book;
import com.tj.edu.practice5.jpa.model.BookAndId;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByName(String name);

    // JPQL
    @Query(value = "select b from Book b where name = ?1")
    List<Book> findByMyBooks(String name);

    @Query(value = "select b from Book b where name = ?2 and id = ?1")
    List<Book> findByMyBooksAndMyId(Long id, String name);

    @Query(value = "select b from Book b where name like %:name% and id = :id")
    List<Book> findByNamedByMyBooksAndMyId(@Param("id") Long id, @Param("name") String name);

    @Query(value = "select b.name from Book b where name = ?1")
    List<String> findNameByMyBooks(String name);

    // return 해주는 book객체를 convert가 안되서 안되는 메소드
    @Query(value = "select b.id id, b.name name from Book b where name = ?1")
//    List<Book> findNameIdByMyBooks(String name);
    List<Map<String, Object>> findNameIdByMyBooks(String name);

    @Query(value = "select b.id id, b.name name from Book b where name = :name")
    List<Map<String, Object>> findByNamedNameIdByMyBooks(@Param("name") String name);
    @Query(value = "select b.id abc, b.name name2 from Book b where name = :name")
//    List<BookAndId> findByCustomNamedNameIdByMyBooks(@Param("name") String name);
    abstract List<Tuple> findByCustomNamedNameIdByMyBooks(@Param("name") String name);

    @Query(value = "select * from Book where name = ?1", nativeQuery = true)
    List<Book> findByNativeByMyBooks(String name);

    @Query(value = "select * from book where name = :name1"
            + " and id = 1 "
            + " and 1 = 1", nativeQuery = true)
    List<Book> findByNativeNameByMyBooks(@Param("name1") String name);

    @Query(value = "select * from book where name = :#{#book.name}", nativeQuery = true)
    List<Book> findByNativeNameByMyBooks2(@Param("book") Book book);

    //    @Transactional
    @Modifying
    @Query(value = "update book set name = '이상한자바책' where id = :id", nativeQuery = true)
    int updateSpecificNameByJPQL(@Param("id") Long id);

//    @Query(value = """
//            SELECT  DISTINCT P.PRODUCTNO,
//                    P_PRICE,
//                    P_NAME,
//                    P_CDATETIME,
//                    PI.SRCIMGNO,
//                    PI.IMGSRC,
//                    PI.IMGNAME,
//                    PI.ORGNAME,
//                    PI.IMGTYPE
//            FROM mini_db2.T1_PRODUCT P
//            LEFT JOIN mini_db2.T1_PDIMAGE PI ON PI.PRODUCTNO = P.PRODUCTNO
//            WHERE P.PRODUCTNO = :productNo
//            AND MAINYN = 'T'
//            """, nativeQuery = true)
//    List<Book> findByNativeNameByMyBooks2(String productNos);

    List<Book> findByNameIsNullAndNameEqualsAndCreateAtGreaterThanEqualAndUpdateAtLessThan(String name, LocalDateTime createAt, LocalDateTime updateAt);
}
