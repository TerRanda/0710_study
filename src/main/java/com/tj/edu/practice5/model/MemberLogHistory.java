package com.tj.edu.practice5.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberLogHistory extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Column(name = "member_id", updatable = false, insertable=false)
//    private Long memberId;
    private String name;
    private String email;
    private Boolean male;

    @ManyToOne
    private Member member;

}
