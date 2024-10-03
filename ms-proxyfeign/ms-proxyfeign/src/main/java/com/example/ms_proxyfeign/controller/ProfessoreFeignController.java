package com.example.ms_proxyfeign.controller;

import com.example.ms_professore.model.Professore;
import com.example.ms_proxyfeign.client.ProfessoreFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feign/professori")
public class ProfessoreFeignController {
    private final ProfessoreFeignClient professoreFeignClient;

    @Autowired
    public ProfessoreFeignController(ProfessoreFeignClient professoreFeignClient) {
        this.professoreFeignClient = professoreFeignClient;
    }

    // Create a new Professore
    @PostMapping
    public ResponseEntity<Professore> createProfessore(@RequestBody Professore professore) {
        return professoreFeignClient.createProfessore(professore);
    }

    // Get all Professori
    @GetMapping
    public ResponseEntity<List<Professore>> getAllProfessori() {
        return professoreFeignClient.getAllProfessori();
    }

    // Get a Professore by ID
    @GetMapping("/{id}")
    public ResponseEntity<Professore> getProfessoreById(@PathVariable Long id) {
        return professoreFeignClient.getProfessoreById(id);
    }

    // Update a Professore
    @PutMapping("/{id}")
    public ResponseEntity<Professore> updateProfessore(@PathVariable Long id, @RequestBody Professore professoreDetails) {
        return professoreFeignClient.updateProfessore(id, professoreDetails);
    }

    // Delete a Professore
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfessore(@PathVariable Long id) {
        professoreFeignClient.deleteProfessore(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
