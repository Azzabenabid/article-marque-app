package com.example.servicearticle.dto;

import java.math.BigDecimal;

public record ArticleDto(Long id, String name, int quantity , double prix, String idMarque) {}
