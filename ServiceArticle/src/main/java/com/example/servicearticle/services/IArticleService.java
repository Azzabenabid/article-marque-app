package com.example.servicearticle.services;

import com.example.servicearticle.dto.ArticleDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface IArticleService {

    ArticleDto add(ArticleDto articleDto);

    ArticleDto update(Long idArticle, Map<Object, Object> fields);  // ID changé en Long

    boolean delete(Long idArticle);  // ID changé en Long

    List<ArticleDto> getArticles();

    ArticleDto getArticle(Long id);  // ID changé en Long

    ArticleDto getArticleByName(String name);
}
