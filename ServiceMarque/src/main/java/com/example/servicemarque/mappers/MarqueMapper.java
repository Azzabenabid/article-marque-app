package com.example.servicemarque.mappers;

import com.example.servicemarque.dto.MarqueDto;
import com.example.servicemarque.entities.Marque;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MarqueMapper {
    Marque mapToEntity(MarqueDto marqueDto);
    MarqueDto mapToDto(Marque marque);
}