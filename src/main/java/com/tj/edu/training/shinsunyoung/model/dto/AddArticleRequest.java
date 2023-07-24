package com.tj.edu.training.shinsunyoung.model.dto;


import com.tj.edu.training.shinsunyoung.model.Article;
import jakarta.persistence.Entity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AddArticleRequest {
    private String title;

    private String content;


    public Article toEntity(String reqAuthor) {
        return Article.builder()
                .title(title)
                .content(content)
                .author(reqAuthor)
                .build();
    }
}
