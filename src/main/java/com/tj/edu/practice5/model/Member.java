package com.tj.edu.practice5.model;

import com.tj.edu.practice5.model.enums.Nation;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ManyToAny;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.security.PrivateKey;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Getter
//@Setter
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "member")
//@EntityListeners(value = { MemberEntityListener.class, TimeAuditEntityListener.class})
//@EntityListeners(value = {AuditingEntityListener.class, MemberEntityListener.class})
@EntityListeners(value = {AuditingEntityListener.class})
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue
    private Long id;
    //    @NonNull
    @Column(nullable = false, columnDefinition = "varchar(5)")
    @ToString.Exclude
    private String name;
    @Column(columnDefinition = "varchar(100)")
    private String email;

    //    @Column(name = "colTest2", unique = true)
    @Column(name = "colTest2", insertable = false, updatable = false)
//    @Transient
    private Integer test2;

//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Address> address;

    private Boolean male;

    @Transient
    private String testData;

    //    @Column(columnDefinition = "varchar(100)")
    @Enumerated(value = EnumType.STRING)
    private Nation nation;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id", insertable = false, updatable = false)
    private List<MemberLogHistory> memberLogHistories;

//    @OneToMany(fetch = FetchType.EAGER)
    @OneToMany
    @JoinColumn(name = "member_id")
    @ToString.Exclude
    private List<Review> reviews;

    @PreRemove
    public void preDelete1() {
        System.out.println(">>> preDelete1()");
    }
    @PostPersist
    public void afterInsert1() {
        System.out.println(">>> afterInsert1()");
    }
    @PostUpdate
    public void afterUpdate1() {
        System.out.println(">>> afterUpdate1()");
    }
    @PostRemove
    public void afterDelete1() {
        System.out.println(">>> afterDelete1()");
    }
    @PostLoad
    public void afterSelect1() {
        System.out.println(">>> afterSelect1()");
    }

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
////    @NonNull, nullable 거의 같은 효과. 널이면 안되는 정보에 추가.
////    columnDefinition: "dataType 꼭 넣어야함." , 데이터타입 변경도 가능! DDL 확인.
//    @Column(columnDefinition = "varchar(1000) comment '이름이다'",nullable = false)
//    private String name;
//    private String email;
////    @Column(name = "colTest2", unique = true)
//    @Column(name = "colTest2", insertable = false, updatable = false)
//    private Integer test2;
////    @NonNull
//    @Column(updatable = false) //업데이트시에 무시됨. create 시점은 인서트할 때만 필요.
//    private LocalDateTime createAt;
//    @Column(columnDefinition = "datetime(6) DEFAULT now() comment '수정시간'")
//    private LocalDateTime updateAt;
////    유저기준
////    @ManyToOne
////    @ManyToMany
////    @ManyToAny
//    @OneToMany(fetch = FetchType.EAGER) //EAGER: 조회한거 다 가져오라는 뜻
//    private List<Address> address;
//    @Column(columnDefinition = "bit(1) comment '성별'")
//    private Boolean male;
////      컬럼 사라지게 함. 다른 어노테이션 효과도 적용 안됨. java bean 말고 jakarta거로.
//    @Transient
//    private String testData;
////    Enum
////    Enumerated: value값을 따로 지정해주는기능
////    환경에 따라 Enum 이름이 바뀌나? 컬럼값을 지정해주라 하셨당
//    @Column(columnDefinition = "Nation")
////    @Enumerated(value = EnumType.STRING) : 숫자대신 한글로 값 출력할 때.
//    @Enumerated(value = EnumType.STRING)
//    private Nation nation;
//    @PrePersist
//    public void preInsert1(){
//        System.out.println(">>> preInsert1() 호출");
//    }
//    @PreUpdate
//    public void preUpdate1(){
//        System.out.println(">>> preUpdate1() 호출");
//    }
//    @PreRemove
//    public void preDelete1(){
//        System.out.println(">>> preDelete1() 호출");
//    }
//    @PostPersist
//    public void afterInsert1(){
//        System.out.println(">>> afterInsert1() 호출");
//    }
//    @PostUpdate
//    public void afterUpdate1(){
//        System.out.println(">>> afterUpdate1() 호출");
//    }
//    @PostRemove
//    public void afterDelete1(){
//        System.out.println(">>> afterDelete1() 호출");
//    }
//    @PostLoad
//    public void afterSelect1(){
//        System.out.println(">>> afterSelect1() 호출");
//    }
}
