package com.tj.edu.practice5.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@EntityListeners(value = {AuditingEntityListener.class})
@EqualsAndHashCode(callSuper = true)
@Table(name = "publisher")
public class Publisher extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany
    @JoinColumn(name = "publisher_id")
    private List<Book> books;
}
