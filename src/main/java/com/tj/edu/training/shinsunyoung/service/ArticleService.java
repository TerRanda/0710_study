package com.tj.edu.training.shinsunyoung.service;

import com.tj.edu.training.shinsunyoung.model.Article;
import com.tj.edu.training.shinsunyoung.model.dto.AddArticleRequest;
import com.tj.edu.training.shinsunyoung.model.dto.UpdateArticleRequest;
import com.tj.edu.training.shinsunyoung.repository.ArticleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;
//블로그 글 저장
    public Article save(AddArticleRequest addArticleRequest) {
        return articleRepository.save(addArticleRequest.toEntity());
    }
//블로그 글 목록 불러오기
    public List<Article> getArticleAll() {
        return articleRepository.findAll();
    }
//글 상세정보 가져오기
    public Article getArticleId(long articleId) {
        return articleRepository.findById(articleId)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + articleId));
    }

    public void delete(long id) {
        articleRepository.deleteById(id);
    }

    @Transactional
    public Article update(long articleId, UpdateArticleRequest updateArticleRequest) {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + articleId));
        //transactional 안필요
//        article.setTitle(updateArticleRequest.getTitle());
//        article.setContent(updateArticleRequest.getContent());
//        return articleRepository.save(article);

        //transactional 필요
        article.update(updateArticleRequest.getTitle(), updateArticleRequest.getContent());

        return article;
    }
}
