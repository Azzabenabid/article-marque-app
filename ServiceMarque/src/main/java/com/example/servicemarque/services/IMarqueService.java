package com.example.servicemarque.services;

import com.example.servicemarque.dto.MarqueDto;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface IMarqueService {

    MarqueDto add(MarqueDto marqueDto);

    MarqueDto update(String idMarque, Map<Object,Object> fields);

    boolean delete(String idMarque);

    Page<MarqueDto> getMarques(int pageNbr, int pageSize);

    MarqueDto getMarque(String id);

    MarqueDto getMarqueByName(String name);
}