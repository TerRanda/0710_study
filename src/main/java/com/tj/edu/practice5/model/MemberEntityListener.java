package com.tj.edu.practice5.model;

import com.tj.edu.practice5.repository.MemberLogHistoryRepository;
import com.tj.edu.practice5.util.SpringBeanUtils;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;

import java.time.LocalDateTime;

public class MemberEntityListener {
    @PrePersist
    @PostUpdate
    public void afterMemberSave(Object o) {
        MemberLogHistoryRepository memberLogHistoryRepository =
                SpringBeanUtils.getBean(MemberLogHistoryRepository.class);

        Member member = (Member) o;

        MemberLogHistory memberLogHistory = MemberLogHistory.builder()
                .member(member)
                .name(member.getName())
                .email(member.getEmail())
                .build();

        memberLogHistoryRepository.save(memberLogHistory);
    }
}
