package com.example.servicearticle.controllers;

import com.example.servicearticle.dto.ArticleDto;
import com.example.servicearticle.services.IArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

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
    public Page<ArticleDto> getArticles(@RequestParam int pageNbr, @RequestParam int pageSize){
        return articleService.getArticles(pageNbr, pageSize);
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
