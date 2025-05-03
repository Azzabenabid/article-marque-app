package com.example.servicemarque.dto;

import lombok.Data;

@Data
public class ArticleDTO {
    private Long id;
    private String nom;
    private double prix;
    private Long marqueId;
}
