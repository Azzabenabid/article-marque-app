package com.example.servicearticle.controllers;

import com.example.servicearticle.dto.ArticleDto;
import com.example.servicearticle.services.IArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleRestController {

    private final IArticleService articleService;

    @PostMapping
    public ArticleDto add(@RequestBody ArticleDto articleDto) {
        return articleService.add(articleDto);
    }

    @PatchMapping("{id}")
    public ArticleDto patchUpdate(@RequestBody Map<Object, Object> fields, @PathVariable Long id){
        return articleService.update(id, fields);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable Long id){
        return articleService.delete(id);
    }

    @GetMapping
    public List<ArticleDto> getArticles() {
        return articleService.getArticles();  // Pas de pagination, on récupère tous les articles
    }

    @GetMapping("{id}")
    public ArticleDto getArticle(@PathVariable Long id){
        return articleService.getArticle(id);
    }

    @GetMapping("name/{name}")
    public ArticleDto getArticleByName(@PathVariable String name){
        return articleService.getArticleByName(name);
    }
}
