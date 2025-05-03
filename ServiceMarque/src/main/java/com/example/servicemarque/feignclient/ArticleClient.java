package com.example.servicemarque.feignclient;

import com.example.servicemarque.dto.ArticleDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "service-article", url = "http://localhost:9091")
public interface ArticleClient {

    @GetMapping("/articles/marque/{marqueId}")
    List<ArticleDTO> getArticlesByMarque(@PathVariable("marqueId") String marqueId);

    @PostMapping("/articles")
    ArticleDTO createArticle(@RequestBody ArticleDTO articleDto);
}

