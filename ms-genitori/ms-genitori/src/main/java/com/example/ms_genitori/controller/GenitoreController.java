package com.example.ms_genitori.controller;

import com.example.ms_genitori.model.Genitore;
import com.example.ms_genitori.service.IGenitoreService;
import com.example.ms_proxyfeign.model.GenericFeignClient;
import com.example.ms_studente.model.Studente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/genitori") // Base URL for the controller
public class GenitoreController {

    @Autowired
    private IGenitoreService genitoreService;

    // Endpoint to create a new Genitore
    @PostMapping
    public ResponseEntity<Genitore> createGenitore(@RequestBody Genitore genitore) {
        Genitore createdGenitore = genitoreService.createGenitore(genitore);
        return new ResponseEntity<>(createdGenitore, HttpStatus.CREATED);
    }

    // Endpoint to retrieve a Genitore by ID
    @GetMapping("/{id}")
    public ResponseEntity<Genitore> getGenitoreById(@PathVariable Long id) {
        Genitore genitore = genitoreService.getGenitoreById(id);
        if (genitore != null) {
            return ResponseEntity.ok(genitore);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Chiamate proxy a ms-studenti
     * @return
     */
    @GetMapping("/f")
    public List<Studente> provaProva(){
        return genitoreService.provaStudenti();
    }

    @GetMapping("/s/{idStudente}")
    public Optional<?> trovaStudenteProviamo(@PathVariable Long idStudente){
        return genitoreService.getStudenteById(idStudente);
    }


    // Endpoint to retrieve all Genitori
    @GetMapping
    public ResponseEntity<List<Genitore>> getAllGenitori() {
        List<Genitore> genitori = genitoreService.getAllGenitori();
        return ResponseEntity.ok(genitori);
    }

    // Endpoint to update a Genitore
    @PutMapping("/{id}")
    public ResponseEntity<Genitore> updateGenitore(@PathVariable Long id, @RequestBody Genitore genitore) {
        Genitore updatedGenitore = genitoreService.updateGenitore(id, genitore);
        if (updatedGenitore != null) {
            return ResponseEntity.ok(updatedGenitore);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint to delete a Genitore
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenitore(@PathVariable Long id) {
        genitoreService.deleteGenitore(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint to retrieve students associated with a Genitore
    @GetMapping("/{genitoreId}/studenti")
    public ResponseEntity<List<?>> getStudentiForGenitore(@PathVariable Long genitoreId) {
        List<?> studenti = genitoreService.getStudentiForGenitore(genitoreId);
        return ResponseEntity.ok(studenti);
    }

    // Endpoint to retrieve a specific student associated with a Genitore
    @GetMapping("/{genitoreId}/studenti/{studenteId}")
    public ResponseEntity<?> getStudenteForGenitore(@PathVariable Long genitoreId, @PathVariable Long studenteId) {
        Optional<?> studente = genitoreService.getStudenteForGenitore(genitoreId, studenteId);
        return studente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint to delete a specific student associated with a Genitore
    @DeleteMapping("/{genitoreId}/studenti/{studenteId}")
    public ResponseEntity<Void> deleteStudenteForGenitore(@PathVariable Long genitoreId, @PathVariable Long studenteId) {
        genitoreService.deleteStudenteForGenitore(genitoreId, studenteId);
        return ResponseEntity.noContent().build();
    }
}
