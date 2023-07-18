package com.tj.edu.practice5.repository;

import com.tj.edu.practice5.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {
    List<Users> findByName(String name);
}
