package com.tj.edu.practice5.lombok.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity(name = "memberLombok")
//Entity 이름을 변경해줘야 오류안남.
@Table(name = "memberLombok")
public class Member {
    @Id
    private Long id;
    private Integer age;
}
