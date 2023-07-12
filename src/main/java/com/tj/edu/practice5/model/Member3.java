package com.tj.edu.practice5.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "member3")
public class Member3 {
    @NonNull
    private String name;
    private int age;
    @Id
    private String id;
    private String nickname;
    private String email;
    @Transient
    private LocalDateTime createAt;
}
