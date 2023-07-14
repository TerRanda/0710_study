package com.tj.edu.practice5.repository;

import com.tj.edu.practice5.model.MemberLogHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberLogHistoryRepository extends JpaRepository<MemberLogHistory, Long> {
    List<MemberLogHistory> findByMemberId(Long memberId);
}
