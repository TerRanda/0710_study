package com.tj.edu.practice5.repository;


import com.tj.edu.practice5.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
