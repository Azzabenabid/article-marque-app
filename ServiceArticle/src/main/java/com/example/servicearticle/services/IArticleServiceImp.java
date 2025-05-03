package com.example.servicearticle.services;

import com.example.servicearticle.mappers.ArticleMapper;
import com.example.servicearticle.entities.Article;
import com.example.servicearticle.repositories.ArticleRepository;
import com.example.servicearticle.dto.ArticleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IArticleServiceImp implements IArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper;

    @Override
    public ArticleDto add(ArticleDto articleDto) {
        System.out.println("Reçu : " + articleDto);
        Article article = articleMapper.mapToEntity(articleDto);
        System.out.println("Entité générée : " + article);
        return articleMapper.mapToDto(articleRepository.save(article));
    }

    @Override
    public ArticleDto update(Long idArticle, Map<Object, Object> fields) {
        Article article = articleRepository.findById(idArticle)
                .orElseThrow(() -> new IllegalArgumentException("Article not found: " + idArticle));

        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Article.class, (String) key);
            field.setAccessible(true);

            if(field.getType().equals(LocalDate.class)){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Correction du format
                LocalDate localDate = LocalDate.parse((String) value, formatter);
                ReflectionUtils.setField(field, article, localDate);
            } else {
                ReflectionUtils.setField(field, article, value);
            }
        });
        return articleMapper.mapToDto(articleRepository.save(article));
    }

    @Override
    public boolean delete(Long idArticle) {
        articleRepository.deleteById(idArticle);
        return !articleRepository.existsById(idArticle);  // Vérification que l'article a bien été supprimé
    }

    @Override
    public List<ArticleDto> getArticles() {
        List<Article> articles = articleRepository.findAll();  // Récupère tous les articles
        return articles.stream().map(articleMapper::mapToDto).collect(Collectors.toList());  // Convertir chaque article en DTO
    }


    @Override
    public ArticleDto getArticle(Long id) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Article not found: " + id));
        return articleMapper.mapToDto(article);  // Conversion de l'entité en DTO
    }

    @Override
    public ArticleDto getArticleByName(String name) {
        Article article = articleRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("Article not found with name: " + name));
        return articleMapper.mapToDto(article);  // Conversion de l'entité en DTO
    }
}
