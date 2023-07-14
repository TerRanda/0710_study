package com.tj.edu.practice5.repository;

import com.tj.edu.practice5.model.Member;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class JpaQueryMethodTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    void jpaQueryMethodTest1(){
        //이메일 값으로 특정 row데이터 가져오기
//        Member memberLeesunsin = memberRepository.findByEmail("leesunsin@gmail.com");
//        System.out.println(memberLeesunsin);

        Set<Member> memberLeesunsin = memberRepository.readByEmail("leesunsin@gmail.com");
        System.out.println(memberLeesunsin);

        //name값으로 가져오기

        List<Member> memberHonggildong = memberRepository.findByName("홍길동");
        System.out.println(memberHonggildong);

        boolean memberNamsun = memberRepository.existsByName("박남순");
        assertTrue(memberNamsun);

//        Count는 어떻게 쓰냐...
//        List<Member> memberKang = memberRepository.findByName("강감찬");


//        Optional<Member> memberOptional1 = memberRepository.findByCreateAt(LocalDateTime.MAX);
//        System.out.println(memberOptional1);

        memberRepository.findFirst1ByEmail("namsun@gmail.com").forEach(System.out::println);
        memberRepository.findFirst2ByEmail("namsun@gmail.com").forEach(System.out::println);
        memberRepository.findTop2ByEmail("namsun@gmail.com").forEach(System.out::println);
        memberRepository.findDistinctByEmail("namsun@gmail.com").forEach(System.out::println);
    }
    @Test
    void jpaQueryMethodTest2(){
//        List<Member> memberList = memberRepository.findByNameAndEmail("홍길동", "mars@thejoeun.com");
//        System.out.println(memberList);
//
//        List<Member> memberList2 = memberRepository.findByNameAndId("홍길동", 1L);
//        System.out.println(memberList2);
//
//        List<Member> memberList3 = memberRepository.findByNameAndIdOrEmail("홍길동", 1L, "kangkamchan@gmail.com");
//        System.out.println(memberList3);
//
//        List<Member> memberList4 = memberRepository.findByCreateAtAfter(LocalDateTime.now().minusDays(1L));
//        memberList4.forEach(s -> System.out.println(s));
//
//        List<Member> memberList5 = memberRepository.findByIdGreaterThan(3L);
//        memberList5.forEach(s -> System.out.println(s));
//
//        List<Member> memberList6 = memberRepository.findByCreateAtGreaterThan(LocalDateTime.now().minusDays(1L));
//        memberList6.forEach(s -> System.out.println(s));

//        List<Member> memberList7 = memberRepository.findByCreateAtGreaterThanEqual(LocalDateTime.now().minusDays(1L));
//        memberList7.forEach(s -> System.out.println(s));
//
//        List<Member> memberList8 = memberRepository.findByIdGreaterThanEqual(3L);
//        memberList8.forEach(s -> System.out.println(s));

//        List<Member> memberList9 = memberRepository.findByCreateAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(1L));
//        memberList9.forEach(s -> System.out.println(s));
//
//        List<Member> memberList10 = memberRepository.findByEmailIsNotNull();
//        memberList10.forEach(s -> System.out.println(s));

//        List<Member> memberList11 = memberRepository.findByNameLike("%홍%");
//        memberList11.forEach(s -> System.out.println(s));
//
//        List<Member> memberList12 = memberRepository.findByNameLikeAndEmailLike("%홍%", "%joeun%");
//        memberList12.forEach(s -> System.out.println(s));
//
//        List<Member> memberList13 = memberRepository.findByNameIn(Lists.newArrayList("이순신","강감찬"));
//        memberList13.forEach(s -> System.out.println(s));
//
//        List<Member> memberList14 = memberRepository.findByNameContains("강");
//        memberList14.forEach(s -> System.out.println(s));
//
//        List<Member> memberList15 = memberRepository.findByNameEndingWith("동");
//        memberList15.forEach(s -> System.out.println(s));

//        List<Member> memberList16 = memberRepository.findByNameOrderByEmail("홍길동");
//        memberList16.forEach(s -> System.out.println(s));
//
//        List<Member> memberList17 = memberRepository.findByEmailLikeOrderByNameDesc("%gmail%");
//        memberList17.forEach(s -> System.out.println(s));

//        List<Member> memberList18 = memberRepository.findByAddressIsEmpty();
//        memberList18.forEach(s -> System.out.println(s));

//        List<Member> memberList19 = memberRepository.findByMaleIsFalse();
//        memberList19.forEach(s -> System.out.println(s));

        Page<Member> pageMember = memberRepository.findByName("홍길동", PageRequest.of(0, 3, Sort.by(Sort.Order.desc("id"),Sort.Order.asc("name"))));
        List<Member> memberList20 = pageMember.getContent();
        memberList20.forEach(System.out::println);

        Page<Member> pageMember2 = memberRepository.findByEmailLike("%t1%", PageRequest.of(0, 3, Sort.by(Sort.Order.asc("email"))));
        List<Member> memberList21 = pageMember2.getContent();
        memberList21.forEach(System.out::println);

    }
}
