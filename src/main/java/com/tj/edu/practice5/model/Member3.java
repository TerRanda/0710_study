package com.tj.edu.practice5.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Member3 {
    @NonNull
    private String name;
    private int age;
    @Id
    private String id;
    private String nickname;
    private String email;
}
