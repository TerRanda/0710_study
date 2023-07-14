package com.tj.edu.practice5.repository;

import com.tj.edu.practice5.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
