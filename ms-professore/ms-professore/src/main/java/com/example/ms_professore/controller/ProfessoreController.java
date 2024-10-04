package com.example.ms_professore.controller;

import com.example.ms_professore.model.Professore;
import com.example.ms_professore.service.ProfService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professori")
@Slf4j
public class ProfessoreController {

    private final ProfService professoreService;

    @Autowired
    public ProfessoreController(ProfService professoreService) {
        this.professoreService = professoreService;
    }

    // Create a new Professore
    @PostMapping
    public ResponseEntity<Professore> createProfessore(@RequestBody Professore professore) {
        Professore createdProfessore = professoreService.createProfessore(professore);
        return new ResponseEntity<>(createdProfessore, HttpStatus.CREATED);
    }

    // Get all Professori
    @GetMapping
    public ResponseEntity<List<Professore>> getAllProfessori() {
        log.info("SONO NEL METODO GET AL PROFESSORI");
        List<Professore> professori = professoreService.getAllProfessori();
        return new ResponseEntity<>(professori, HttpStatus.OK);
    }

    // Get a Professore by ID
    @GetMapping("/{id}")
    public ResponseEntity<Professore> getProfessoreById(@PathVariable Long id) {
        Professore professore = professoreService.getProfessoreById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Professore not found with id " + id));
        return new ResponseEntity<>(professore, HttpStatus.OK);
    }

    // Update a Professore
    @PutMapping("/{id}")
    public ResponseEntity<Professore> updateProfessore(@PathVariable Long id, @RequestBody Professore professoreDetails) {
        Professore updatedProfessore = professoreService.updateProfessore(id, professoreDetails);
        return new ResponseEntity<>(updatedProfessore, HttpStatus.OK);
    }

    // Delete a Professore
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfessore(@PathVariable Long id) {
        professoreService.deleteProfessore(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}