package com.example.servicearticle.mappers;

import com.example.servicearticle.dto.ArticleDto;
import com.example.servicearticle.entities.Article;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArticleMapper {
    Article mapToEntity(ArticleDto articleDto);
    ArticleDto mapToDto(Article marque);
}