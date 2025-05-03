package com.example.servicemarque.repositories;


import com.example.servicemarque.entities.Marque;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MarqueRepository extends MongoRepository<Marque, String> {

    Optional<Marque> findByName(String name);
}