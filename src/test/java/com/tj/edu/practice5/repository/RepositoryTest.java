package com.tj.edu.practice5.repository;

import com.tj.edu.practice5.model.Address;
import com.tj.edu.practice5.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RepositoryTest {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Test
    void bookRepositoryTest() throws InterruptedException {
        Book book = Book.builder()
                .name("스프링 부트 3 백엔드 개발자 되기")
//                .author("신선영")
                .build();
        Book book2 = bookRepository.save(book);

        Thread.sleep(1000);
//        book2.setAuthor("ShinSunYeong");
        bookRepository.save(book2);
    }
    @Test
    void addressRepositoryTest() throws InterruptedException {
        Address address = Address.builder()
                .zipcode("101-111")
                .build();
        addressRepository.save(address);

        Address address2 = Address.builder()
                .zipcode("101-222")
                .build();
        addressRepository.save(address2);

        Address address3 = Address.builder()
                .zipcode("101-333")
                .build();
        addressRepository.save(address3);

        Thread.sleep(5000);
        address3.setZipcode("101-444");
        addressRepository.save(address3);
    }
}