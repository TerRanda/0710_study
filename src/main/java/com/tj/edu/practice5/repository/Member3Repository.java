package com.tj.edu.practice5.repository;

import com.tj.edu.practice5.model.Member3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Member3Repository extends JpaRepository<Member3, Long> {
}
