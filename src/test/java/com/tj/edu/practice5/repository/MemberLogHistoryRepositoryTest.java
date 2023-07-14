package com.tj.edu.practice5.repository;

import com.tj.edu.practice5.model.Member;
import com.tj.edu.practice5.model.MemberLogHistory;
import com.tj.edu.practice5.model.enums.Nation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class MemberLogHistoryRepositoryTest {
    @Autowired
    private MemberLogHistoryRepository memberLogHistoryRepository;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    void selectRelationTest1() {
        givenMember();

        List<MemberLogHistory> memberLogHistoryList
                = memberLogHistoryRepository.findAll();
        System.out.println(">>>" + memberLogHistoryList);
    }

    private Member givenMember() {
        Member member1 = Member.builder()
                .name("최우제")
                .email("zeus04@t1esports.com")
                .nation(Nation.KOREA)
                .build();
        Member member = memberRepository.save(member1);
        return memberRepository.save(member);
    }
}