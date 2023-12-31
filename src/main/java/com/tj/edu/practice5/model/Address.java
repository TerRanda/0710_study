package com.tj.edu.practice5.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(callSuper = true)
@Entity
@EntityListeners(value = {AuditingEntityListener.class})
@EqualsAndHashCode(callSuper = false)
public class Address extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String zipcode;
//    @OneToOne
//    private Member member;

}
