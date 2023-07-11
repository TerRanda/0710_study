package com.tj.edu.practice5.repository;

import com.tj.edu.practice5.model.Board;
import com.tj.edu.practice5.model.Order;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OrderRepositoryTest {
    @Autowired
    private OrderRepository orderRepository;

    @DisplayName("Order Test")
    @Test
    void orderTest(){
        Order order1 = Order.builder()
                .orderNo(1L)
                .name("치앙마이씨")
                .price("32000")
                .productNo("2023071101543")
                .pName("연유커피")
                .oCdatetime(LocalDateTime.now())
                .build();

        orderRepository.save(order1);

        List<Order> orderList = orderRepository.findAllById(Lists.newArrayList(1L));
        orderList.forEach(System.out::println);
    }
}