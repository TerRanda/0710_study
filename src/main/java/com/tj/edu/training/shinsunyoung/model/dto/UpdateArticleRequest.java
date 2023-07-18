package com.tj.edu.training.shinsunyoung.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateArticleRequest {
    private String title;
    private String content;
}
