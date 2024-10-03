package com.example.ms_scuola.service;

import com.example.ms_scuola.model.Scuola;
import com.example.ms_scuola.repository.ScuolaRepository;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScuolaService {
    private final ScuolaRepository scuolaRepository;

    @Autowired
    public ScuolaService(ScuolaRepository scuolaRepository) {
        this.scuolaRepository = scuolaRepository;
    }

    // Create a new Scuola
    public Scuola createScuola(Scuola scuola) {
        return scuolaRepository.save(scuola);
    }

    // Get all Scuole
    public List<Scuola> getAllScuole() {
        return scuolaRepository.findAll();
    }

    // Get a Scuola by ID
    public Optional<Scuola> getScuolaById(Long id) {
        return scuolaRepository.findById(id);
    }

    // Update a Scuola
    public Scuola updateScuola(Long id, Scuola scuolaDetails) {
        Scuola scuola = scuolaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Scuola not found with id " + id));

        scuola.setNomeScuola(scuolaDetails.getNomeScuola());
        scuola.setIndirizzoScuola(scuolaDetails.getIndirizzoScuola());

        return scuolaRepository.save(scuola);
    }

    // Delete a Scuola
    public void deleteScuola(Long id) {
        Scuola scuola = scuolaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Scuola not found with id " + id));
        scuolaRepository.delete(scuola);
    }
}
