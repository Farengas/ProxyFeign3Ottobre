package com.example.ms_scuola.controller;

import com.example.ms_scuola.model.Scuola;
import com.example.ms_scuola.service.ScuolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scuole")
public class ScuolaController {
    private final ScuolaService scuolaService;

    @Autowired
    public ScuolaController(ScuolaService scuolaService) {
        this.scuolaService = scuolaService;
    }

    // Create a new Scuola
    @PostMapping
    public ResponseEntity<Scuola> createScuola(@RequestBody Scuola scuola) {
        Scuola newScuola = scuolaService.createScuola(scuola);
        return ResponseEntity.ok(newScuola);
    }

    // Get all Scuole
    @GetMapping
    public ResponseEntity<List<Scuola>> getAllScuole() {
        List<Scuola> scuole = scuolaService.getAllScuole();
        return ResponseEntity.ok(scuole);
    }

    // Get a Scuola by ID
    @GetMapping("/{id}")
    public ResponseEntity<Scuola> getScuolaById(@PathVariable Long id) {
        return scuolaService.getScuolaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update a Scuola
    @PutMapping("/{id}")
    public ResponseEntity<Scuola> updateScuola(@PathVariable Long id, @RequestBody Scuola scuolaDetails) {
        Scuola updatedScuola = scuolaService.updateScuola(id, scuolaDetails);
        return ResponseEntity.ok(updatedScuola);
    }

    // Delete a Scuola
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScuola(@PathVariable Long id) {
        scuolaService.deleteScuola(id);
        return ResponseEntity.noContent().build();
    }
}
