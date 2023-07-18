package com.tj.edu.practice5.service;

import com.tj.edu.practice5.model.Users;
import com.tj.edu.practice5.repository.UsersRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;

    @Transactional
    //            public 만 먹힘. 나머지는 안 먹힘
    public void put() {
        Users user = Users.builder()
                .name("포버지")
                .build();
        usersRepository.save(user);
    }
}
