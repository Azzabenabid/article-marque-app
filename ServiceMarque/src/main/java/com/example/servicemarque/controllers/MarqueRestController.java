package com.example.servicemarque.controllers;

import com.example.servicemarque.dto.MarqueDto;
import com.example.servicemarque.services.IMarqueService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/marques")
@RequiredArgsConstructor
public class MarqueRestController {

    private final IMarqueService marqueService;

    @PostMapping
    public MarqueDto add(@RequestBody MarqueDto marqueDto) {
        return marqueService.add(marqueDto);
    }

    @PatchMapping("{id}")
    public MarqueDto patchUpdate(@RequestBody Map<Object,Object> fields, @PathVariable String id){
        return marqueService.update(id,fields);
    }

    @DeleteMapping("{id}")
    public boolean delete( @PathVariable String id){
        return marqueService.delete(id);
    }


    @GetMapping
    public Page<MarqueDto> getMarques(@RequestParam(defaultValue = "0") int pageNbr,
                                      @RequestParam(defaultValue = "10") int pageSize){
        return marqueService.getMarques(pageNbr,pageSize);
    }

    @GetMapping("{id}")
    public MarqueDto getMarque(@PathVariable String id){
        return marqueService.getMarque(id);
    }

    @GetMapping("name/{name}")
    public MarqueDto getMarqueByName(@PathVariable String name){
        return marqueService.getMarqueByName(name);
    }







}