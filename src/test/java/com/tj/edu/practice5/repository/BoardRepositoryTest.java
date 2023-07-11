package com.tj.edu.practice5.repository;

import com.tj.edu.practice5.model.Board;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BoardRepositoryTest {
    @Autowired
    private BoardRepository boardRepository;
    @BeforeEach
    void before(){

    }
    @DisplayName("semiProject sql mapper 코드 작성")
    @Test()
    void crudBoard1() {
    }
    @DisplayName("Board 코드 작성")
    @Test()
    void crudBoard2(){
        Board board1 = Board.builder()
                .boardNo(1L)
                .imgNo(1L)
                .boardKind("질문과답")
                .title("여기 뭐하는 곳인가요?")
                .content("내용")
                .udatetime(LocalDateTime.now())
                .cdatetime(LocalDateTime.now())
                .build();
        boardRepository.save(board1);

       List<Board> boardList = boardRepository.findAllById(Lists.newArrayList(1L));
       boardList.forEach(System.out::println);

    }
    @AfterEach
    void tearDown(){

    }
}