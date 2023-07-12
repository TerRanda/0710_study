package com.tj.edu.practice5.repository;

import com.tj.edu.practice5.model.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
//    Member findByEmail(String email);
//    Member findByName(String name);
    List<Member> findByName(String name);
    Page<Member> findByName(String name, PageRequest pageable);


    List<Member> findByNameAndEmail(String name, String email);
    List<Member> findByNameAndId(String name, Long id);
    List<Member> findByNameAndIdOrEmail(String name, Long id, String email);
//    search, get, query, stream, read 등 find 와 같은 기능함.
//    find랑 By 사이에 다른거 써도 적용됨. 예) findSomethingByName, find'A'By'B(컬럼코드)'
//    List<Member> searchByName(String name);
//    List<Member> getByName(String name);
//    By 뒤에 컬럼에 없는 코드를 넣게되면 오류남. 컴파일러는 통과되는데 실행에서 에러뜸. Failed to load ApplicationContext for ~
//    ByBy같이 써도 오류남.
    boolean existsByName(String name);
    Long countByName(String name);

    Set<Member> readByEmail(String email);
    Page<Member> findByEmailLike(String emailLike, PageRequest pageable);

    Optional<Member> findByCreateAt(LocalDateTime localDateTime);

    List<Member> findFirst1ByEmail(String email);
    List<Member> findFirst2ByEmail(String email);
    List<Member> findTop2ByEmail(String email);
    List<Member> findDistinctByEmail(String email);
    //create 후의 정보 불러오기
    List<Member> findByCreateAtAfter(LocalDateTime yesterday);
    List<Member> findByCreateAtGreaterThan(LocalDateTime yesterday);
    List<Member> findByCreateAtGreaterThanEqual(LocalDateTime yesterday);
    List<Member> findByIdGreaterThanEqual(Long id);
    List<Member> findByIdGreaterThan(Long id);
    List<Member> findByCreateAtBetween(LocalDateTime yesterday, LocalDateTime tomorrow);

    List<Member> findByEmailIsNotNull();
    List<Member> findByNameLike(String likeName);
    List<Member> findByNameLikeAndEmailLike(String likeName, String likeEmail);

    List<Member> findByNameIn(List<String> nameList);
    List<Member> findByNameContains(String name);
    List<Member> findByNameEndingWith(String name);
    List<Member> findByNameOrderByEmail(String name);
    List<Member> findByEmailLikeOrderByNameDesc(String likeEmail);
    List<Member> findByAddressIsEmpty();
    List<Member> findByMaleIsFalse();



}
