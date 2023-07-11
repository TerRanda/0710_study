package com.tj.edu.practice5.repository;

import com.tj.edu.practice5.model.Member;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    void crud() {
//        Member member1 = new Member(1L, "홍길동", null, LocalDateTime.now(), LocalDateTime.now());
        // insert문
//        Member copyMember = memberRepository.save(member1); // insert into Member values (~~~
//        System.out.println("copyMember -> " + copyMember);

//        Member member =
        // select all문
        System.out.println("select all문--------------------------------------------------------");
        List<Member> memberList = memberRepository.findAll(Sort.by(Sort.Direction.DESC, "name")); // == select * from member
        // jdk 1.8에서 사용된 stream기술을 이용한 print찍는 방법
        memberList.forEach(System.out::println);
//        for(Member member : memberList) {
//            System.out.println(member.toString());
//        }

        // select where문
        System.out.println("select where문 --------------------------------------------------------");
        List<Member> memberList2 = memberRepository.findAllById(Lists.newArrayList(1L, 3L, 5L)); // == select * from member where id in (1, 3)
        memberList2.forEach(System.out::println);

        // update문
        System.out.println("update문 --------------------------------------------------------");
        Member member1 = new Member(1L, "홍길동", "이메일 주소", LocalDateTime.now(), LocalDateTime.now());
        memberRepository.save(member1);     // 1번을 가진 id가 있다면 update, 없으면 create문 발생
        List<Member> memberList3 = memberRepository.findAll();
        memberList3.forEach(System.out::println);

        // delete문
//        System.out.println("delete문 --------------------------------------------------------");
//        memberRepository.deleteAll();
//        memberRepository.deleteAllInBatch();
//        List<Member> memberList4 = memberRepository.findAll();
//        memberList4.forEach(System.out::println);

        }
    @Test
    void crud2() {
        //create문
//        Member member = Member.builder()
//                .name("김뽀삐")
//                .createAt(LocalDateTime.now())
//                .build();
//        memberRepository.save(member);
//
//        Member member2 = Member.builder()
//                .updateAt(LocalDateTime.now())
//                .build();
//        memberRepository.save(member2);

        Member member3 = Member.builder()
                .name("박조은")
                .email("parkjoeun@gmail.com")
                .id(15L)
                .createAt(LocalDateTime.now())
                .updateAt(null)
                .build();
        memberRepository.save(member3);
      // select by 2가지 방법 있음.
//        Optional<Member> memberOptional = memberRepository.findById(12L);
////        memberOptional.orElseThrow(RuntimeException::new);
//        System.out.println(memberOptional);
        Member member4 = memberRepository.findById(1L).orElse(null);
        if(member4 != null) {
            System.out.println(member4);
        }
        //2명 정보 동시에 불러오기
        List<Member> memberList = memberRepository.findAllById(Lists.newArrayList(3L, 7L));
        memberList.forEach(System.out::println);

        //select count
        System.out.println("회원 수는 " + memberRepository.count() + "입니다.");

        //select exist함수(값이 있는지 없는지 체크해주는 함수)
        boolean isFiveNumberMember = memberRepository.existsById(5L);
        if(isFiveNumberMember)
            System.out.println("5번 회원 존재");

        boolean isNinetyNumberMember = memberRepository.existsById(90L);
        if(isNinetyNumberMember)
            System.out.println("90번 회원 존재");
        //select page함수
        //자주쓰는 방법은 아닌데. 간단하게 알아볼때 씀.
        Page<Member> membersPage =  memberRepository.findAll(PageRequest.of(0, 4));
        System.out.println("page: " + membersPage);
        System.out.println("totalElements: " + membersPage.getTotalElements());
        System.out.println("totalPage: " + membersPage.getTotalPages());
        System.out.println("numberOfElements: " + membersPage.getNumberOfElements());
        System.out.println("size: " + membersPage.getSize());
        System.out.println("sort: " + membersPage.getSort());

        List<Member> memberList2 = membersPage.getContent();
        memberList2.forEach(System.out::println);

        //jpa find example이용(select)
        ExampleMatcher matcher = ExampleMatcher.matching()
//                .withIgnorePaths("name")
//                .withMatcher("email", endsWith())
                ;
        //startsWith() : 시작하는거

        Example<Member> memberExample = Example.of(
                                        Member.builder()
                                                .name("박남순")
//                                                .email("thejoeun.com")
                                                .build(),
                                        matcher
        );

        memberRepository.findAll(memberExample).forEach(System.out::println);

        Example<Member> memberExample2 = Example.of(
                                                    Member.builder()
                                                            .email("mars@thejoeun.com")
                                                            .build()

        );
        memberRepository.findAll(memberExample2).forEach(System.out::println);
    }



}