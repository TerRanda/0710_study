package com.tj.edu.practice5.repository;

import com.tj.edu.practice5.model.*;
import com.tj.edu.practice5.model.enums.Nation;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired AddressRepository addressRepository;
    @Autowired
    private MemberLogHistoryRepository memberLogHistoryRepository;

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
        Member member1 = Member.builder()
                .id(1L)
                .name("홍길동")
                .email("이메일 주소")
                .build();
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
                .build();
        memberRepository.save(member3);
        // select by 2가지 방법 있음.
//        Optional<Member> memberOptional = memberRepository.findById(12L);
////        memberOptional.orElseThrow(RuntimeException::new);
//        System.out.println(memberOptional);
        Member member4 = memberRepository.findById(1L).orElse(null);
        if (member4 != null) {
            System.out.println(member4);
        }
        //2명 정보 동시에 불러오기
        List<Member> memberList = memberRepository.findAllById(Lists.newArrayList(3L, 7L));
        memberList.forEach(System.out::println);

        //select count
        System.out.println("회원 수는 " + memberRepository.count() + "입니다.");

        //select exist함수(값이 있는지 없는지 체크해주는 함수)
        boolean isFiveNumberMember = memberRepository.existsById(5L);
        if (isFiveNumberMember)
            System.out.println("5번 회원 존재");

        boolean isNinetyNumberMember = memberRepository.existsById(90L);
        if (isNinetyNumberMember)
            System.out.println("90번 회원 존재");
        //select page함수
        //자주쓰는 방법은 아닌데. 간단하게 알아볼때 씀.
        Page<Member> membersPage = memberRepository.findAll(PageRequest.of(0, 4));
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
        @Test
        void crud3(){
            Member member = Member.builder()
                    .name("최우제")
                    .male(false)
                    .email("zeus01@t1esports.com")
                    .build();
            //insert
            member = memberRepository.save(member);
            //update
            member.setName("작번");
            memberRepository.save(member);

            Member member1 = Member.builder()
                    .name("류민석")
                    .male(false)
                    .email("keria@t1esports.com")
                    .build();
            member1 = memberRepository.save(member1);
            //updateable 먹여서 test2는 변경안됨.
            member1.setName("막내아님");
            member1.setTest2(1234);
            memberRepository.saveAndFlush(member1);
    }
    @Test
    void jpaEnumTest(){
        Member member1 = Member.builder()
                .name("류민석")
                .male(false)
                .email("keria@t1esports.com")
                .nation(Nation.KOREA)
                .build();
        member1 = memberRepository.save(member1);

        Member member2 = Member.builder()
                .name("문현준")
                .male(false)
                .email("owner@t1esports.com")
                .nation(Nation.기타)
                .build();
        member2 = memberRepository.save(member2);
    }
    @Test
    void jpaEventListenerTest(){
        Member member1 = Member.builder()
                .name("류민석")
                .male(false)
                .email("keria@t1esports.com")
                .nation(Nation.KOREA)
                .build();
        memberRepository.save(member1); //insert

        Member member2 = memberRepository.findById(1L).orElseThrow(RuntimeException::new);
        member2.setName("국대서폿");
        memberRepository.save(member2); //update(PreUpdate, PostUpdate)

//        memberRepository.deleteById(3L);    //delete(PreRemove, PostRemove)
    }
//    @Test
//    void oneToOneTest1() {
//        Member member = getGivenMember();
//        Address address = getGivenaddress(member);
//
////        bookReviewInfoRepository.findAll();
//        memberRepository.findById(1L);
//    }
//    private Member getGivenMember() {
//        Member member = Member.builder()
//                .name("류민석")
//                .male(false)
//                .email("keria@t1esports.com")
//                .nation(Nation.KOREA)
//                .build();
//        return memberRepository.save(member);
//    }
//    private Address getGivenaddress(Member member) {
//        Address address = Address.builder()
//                .member(member)
//                .zipcode("222-333")
//                .build();
//        return addressRepository.save(address);
//    }
    @Test
    void getOneToManyTest() {
        Member member1 = Member.builder()
                .name("류민석")
                .male(false)
                .email("keria@t1esports.com")
                .nation(Nation.KOREA)
                .build();
        memberRepository.save(member1);

        member1.setName("국대서폿");
        memberRepository.save(member1);

        member1.setName("류민석2");
        memberRepository.save(member1);

        List<MemberLogHistory> memberLogHistoryList = memberRepository.findById(7L).get().getMemberLogHistories();
        memberLogHistoryList.forEach(System.out::println);
//        List<Member> memberList = memberRepository.findAll();
//        Member member2 = memberList.get(0);
//        List<MemberLogHistory> memberLogHistoryList = member2.getMemberLogHistories();
//        System.out.println("memberLog >>> " + memberLogHistoryList);
//        List<MemberLogHistory> memberLogHistories = memberLogHistoryRepository.findByMemberId(member1.getId());
//        Optional<Member> optMember2 = memberRepository.findById(memberLogHistories.get(0).getMemberId());

//        memberRepository.findAll();
    }
    @AfterEach
    void tearDown() {
    }
}