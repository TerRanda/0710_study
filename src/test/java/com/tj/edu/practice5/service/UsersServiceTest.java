package com.tj.edu.practice5.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UsersServiceTest {
    @Autowired
    private UsersService usersService;
    //서비스파일 따로 만들어서 메소드 만들어주면 TEST에서 @Transactional 필요없음.
    @Test
    void transactionalTest() {
        usersService.put();
    }
}