package com.tj.edu.practice5.repository;

import com.tj.edu.practice5.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
