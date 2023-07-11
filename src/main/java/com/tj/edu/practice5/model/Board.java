package com.tj.edu.practice5.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Board {

    @Id
    private Long boardNo;
    private String boardKind;
    private String keywordType;
    private String userId;
    private LocalDateTime cdatetime;
    private LocalDateTime udatetime;
    @NonNull
    private String title;
    @NonNull
    private String content;
    private String viewCnt;
    private String delYn;
    private String replyYn;
    //IMG
    private Long imgNo;
    private Long replyNo;
    private String imgSrc;
    private String imgName;
    private String orgName;
    private String imgType;

}
