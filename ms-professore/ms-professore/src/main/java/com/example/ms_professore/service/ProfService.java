package com.example.ms_professore.service;

import com.example.ms_professore.model.Professore;
import com.example.ms_professore.repository.ProfRepository;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfService {
    private final ProfRepository professoreRepository;



    // Create a new Professore
    public Professore createProfessore(Professore professore) {
        return professoreRepository.save(professore);
    }

    // Get all Professori
    public List<Professore> getAllProfessori() {
        return professoreRepository.findAll();
    }

    // Get a Professore by ID
    public Optional<Professore> getProfessoreById(Long id) {
        return professoreRepository.findById(id);
    }

    // Update a Professore
    public Professore updateProfessore(Long id, Professore professoreDetails) {
        Professore professore = professoreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Professore not found with id " + id));

        professore.setNomeProfessore(professoreDetails.getNomeProfessore());
        professore.setCognomeProfessore(professoreDetails.getCognomeProfessore());

        return professoreRepository.save(professore);
    }

    // Delete a Professore
    public void deleteProfessore(Long id) {
        Professore professore = professoreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Professore not found with id " + id));
        professoreRepository.delete(professore);
    }
}
