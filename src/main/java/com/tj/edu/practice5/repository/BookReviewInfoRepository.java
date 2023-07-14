package com.tj.edu.practice5.repository;

import com.tj.edu.practice5.model.BookReviewInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookReviewInfoRepository extends JpaRepository<BookReviewInfo, Long> {
}
