package com.tj.edu.practice5.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Address {
    @Id
    private Long id;
    private String zipcode;
}
