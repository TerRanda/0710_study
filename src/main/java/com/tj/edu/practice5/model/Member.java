package com.tj.edu.practice5.model;

import com.tj.edu.practice5.model.enums.Nation;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ManyToAny;

import java.security.PrivateKey;
import java.time.LocalDateTime;
import java.util.List;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
//@Table(name = "member", uniqueConstraints = {@UniqueConstraint(columnNames ={""} )},indexes = {@Index(columnList = {""} )})
@Table(name = "member", uniqueConstraints = {@UniqueConstraint(columnNames ={"colTest2"})})
public class Member {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @NonNull, nullable 거의 같은 효과. 널이면 안되는 정보에 추가.
//    columnDefinition: "dataType 꼭 넣어야함." , 데이터타입 변경도 가능! DDL 확인.
    @Column(columnDefinition = "varchar(1000) comment '이름이다'",nullable = false)
    private String name;
    private String email;
//    @Column(name = "colTest2", unique = true)
    @Column(name = "colTest2", insertable = false, updatable = false)
    private Integer test2;
//    @NonNull
    @Column(updatable = false) //업데이트시에 무시됨. create 시점은 인서트할 때만 필요.
    private LocalDateTime createAt;
    @Column(columnDefinition = "datetime(6) DEFAULT now() comment '수정시간'")
    private LocalDateTime updateAt;
//    유저기준
//    @ManyToOne
//    @ManyToMany
//    @ManyToAny
    @OneToMany(fetch = FetchType.EAGER) //EAGER: 조회한거 다 가져오라는 뜻
    private List<Address> address;
    @Column(columnDefinition = "bit(1) comment '성별'")
    private Boolean male;
//      컬럼 사라지게 함. 다른 어노테이션 효과도 적용 안됨. java bean 말고 jakarta거로.
    @Transient
    private String testData;
//    Enum
//    Enumerated: value값을 따로 지정해주는기능
//    환경에 따라 Enum 이름이 바뀌나? 컬럼값을 지정해주라 하셨당
    @Column(columnDefinition = "Nation")
//    @Enumerated(value = EnumType.STRING) : 숫자대신 한글로 값 출력할 때.
    private Nation nation;
}
