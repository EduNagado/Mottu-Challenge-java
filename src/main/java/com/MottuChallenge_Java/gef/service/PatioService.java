package com.MottuChallenge_Java.gef.service;


import com.MottuChallenge_Java.gef.model.Patio;
import com.MottuChallenge_Java.gef.repository.PatioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatioService {
    private final PatioRepository patioRepository;

    @Autowired
    public PatioService(PatioRepository patioRepository) {
        this.patioRepository = patioRepository;
    }

    // CRUD -> Create, Read, Update, Delete
    public Patio createPatio(Patio patio) {
        return patioRepository.save(patio);
    }

    public Patio readPatio(Long id) {
        return patioRepository.findById(id).orElse(null);
    }

    public List<Patio> readPatios() {
        return patioRepository.findAll();
    }

    public Patio updatePatio(Patio patio) {
        return patioRepository.save(patio);
    }

    public void deletePatio(Long id) {
        patioRepository.deleteById(id);
    }
}

