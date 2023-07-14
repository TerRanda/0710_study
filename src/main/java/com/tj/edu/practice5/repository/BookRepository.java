package com.tj.edu.practice5.repository;

import com.tj.edu.practice5.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Long> {
}
