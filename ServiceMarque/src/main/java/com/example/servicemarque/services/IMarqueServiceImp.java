package com.example.servicemarque.services;

import com.example.servicemarque.dto.MarqueDto;
import com.example.servicemarque.entities.Marque;
import com.example.servicemarque.mappers.MarqueMapper;
import com.example.servicemarque.repositories.MarqueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class IMarqueServiceImp implements IMarqueService {
    private final MarqueRepository marqueRepository;
    private final MarqueMapper marqueMapper;

    @Override
    public MarqueDto add(MarqueDto marqueDto) {
        Marque marque = marqueMapper.mapToEntity(marqueDto);
        return marqueMapper.mapToDto(marqueRepository.save(marque));
    }

    @Override
    public MarqueDto update(String idMarque, Map<Object, Object> fields) {
        Marque marque = marqueRepository.findById(idMarque)
                .orElseThrow(() -> new IllegalArgumentException("Marque not found: " + idMarque));

        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Marque.class, (String) key);
            field.setAccessible(true);

            if(field.getType().equals(LocalDate.class)){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-d");
                LocalDate localDate = LocalDate.parse((String) value, formatter);
                ReflectionUtils.setField(field, marque, localDate);
            }else {
                ReflectionUtils.setField(field, marque, value);
            }

        });
        return marqueMapper.mapToDto(marqueRepository.save(marque));
    }

    @Override
    public boolean delete(String idMarque) {
         marqueRepository.deleteById(idMarque);
        return marqueRepository.existsById(idMarque);
    }

    @Override
    public Page<MarqueDto> getMarques(int pageNbr, int pageSize) {
        return marqueRepository.findAll(PageRequest.of(pageNbr,pageSize))
                .map(marqueMapper::mapToDto);
    }

    @Override
    public MarqueDto getMarque(String id) {
        return marqueRepository.findById(id)
                .map(marqueMapper::mapToDto)
                .orElseThrow(() -> new IllegalArgumentException("Marque not found"));
    }

    @Override
    public MarqueDto getMarqueByName(String name) {
        return marqueRepository.findByName(name)
                .map(marqueMapper::mapToDto)
                .orElseThrow(() ->new IllegalArgumentException("Marque not found with this name"));
    }


}