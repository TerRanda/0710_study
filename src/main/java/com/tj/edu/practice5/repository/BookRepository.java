package com.tj.edu.practice5.repository;

import com.tj.edu.practice5.model.Book;
import com.tj.edu.practice5.model.BookAndId;
import jakarta.persistence.Tuple;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByName(String name);
//    JPQL
//    사용하는 목적: 메소드 이름이 너~~~무 길 때.
    @Query(value = "select b from Book b where name = ?1")  //?1 -> name...이랑관련.
    List<Book> findByMyBooks(String name);

    @Query(value = "select b from Book b where name = ?1 and id =?2")  //?1 -> name...이랑관련.
    //Unknown wrap conversion requested -> ?1 과 ?2 바꿨을 때 뜨는 에러. 데이터타입을 맞춰줘야하나보당.
    List<Book> findByNameAndMyId(String name, Long id);
    @Query(value = "select b from Book b where name = :name and id = :id")  //?1 -> name...이랑관련.
        //Unknown wrap conversion requested -> ?1 과 ?2 바꿨을 때 뜨는 에러. 데이터타입을 맞춰줘야하나보당.
    List<Book> findByNameAndMyId2(@Param("name") String name, @Param("id") Long id);
    @Query(value = "select b from Book b where name Like %:name% and id = :id")  //?1 -> name...이랑관련.
        //Unknown wrap conversion requested -> ?1 과 ?2 바꿨을 때 뜨는 에러. 데이터타입을 맞춰줘야하나보당.
    List<Book> findByNameAndMyId3(@Param("name") String name, @Param("id") Long id);
    @Query(value = "select b.id id, b.name name from Book b where name = ?1")  //?1 -> name...이랑관련.
    List<Map<String, Object>> findIdAndNameByBooks(String name);
    //interface. abc name2 만들어서.
    @Query(value = "select b.id abc, b.name name2 from Book b where name = ?1")  //?1 -> name...이랑관련. 네이밍
    List<BookAndId> findBookAndIdByBooks(@Param("name") String name);

    @Query(value = "select b.id num, b.name bookName from Book b where name = ?1")  //?1 -> name...이랑관련. 네이밍
    List<BookAndId> findBookAndIdByBooks2(@Param("name") String name);

    @Query(value = "select b.id abc, b.name name2 from Book b where name = ?1")  //Tuple은 네이밍 필요 없다.
    List<Tuple> findTupleByBooks(@Param("name") String name);

    @Query(value = "select b.id id, b.name name from Book b where name = :name")  //?1 -> name...이랑관련.
    List<Map<String, Object>> findByNamedNameByMyBooks(@Param("name") String name);


    @Query(value = "select * from book where name = ?1", nativeQuery = true)
    List<Book> findByNativeByMyBooks(String name);

    @Query(value = "select * from book where name = :name", nativeQuery = true)
    List<Book> findByNativeNameByMyBooks(@Param("name") String name);


    @Query(value = "select * from book where name = :name1"
            + " and id = 1"
            + " and 1 = 1",
            nativeQuery = true)
    List<Book> findByNativeNameByMyBooks2(@Param("name1") String name);
//  업데이트 쿼리
//    @Transactional  //@Test 부분에 걸면 @Commit도 넣어줘야함.
//    @Query(value = "update book set name = '이상한 자바책' where id = 2", nativeQuery = true)
//    @Modifying
//    int updateSpecificName(@Param("id") Long id);

    @Transactional  //@Test 부분에 걸면 @Commit도 넣어줘야함.
    @Query(value = "insert into book(`id`, `name`, `publisher_id`) values(:id, '유리손목', 1)", nativeQuery = true)
    @Modifying
    int insertSpecificName(@Param("id") Long id);

    @Transactional  //@Test 부분에 걸면 @Commit도 넣어줘야함.
    @Query(value = "update book b set b.name = '이상한 자바책' where b.id = 2", nativeQuery = true)
    @Modifying
    int updateSpecificName(@Param("id") Long id);

    @Transactional  //@Test 부분에 걸면 @Commit도 넣어줘야함.
    @Query(value = "delete from book where id = 2", nativeQuery = true)
    @Modifying
    int deleteSpecificName(@Param("id") Long id);
}
