package com.example.ms_studente.controller;

import com.example.ms_studente.model.Studente;
import com.example.ms_studente.service.IStudenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/studenti")
public class StudenteController {

    private final IStudenteService studenteService;

    @Autowired
    public StudenteController(IStudenteService studenteService) {
        this.studenteService = studenteService;
    }

    // Crea un nuovo studente
    @PostMapping
    public ResponseEntity<Studente> createStudente(@RequestBody Studente studente) {
        Studente createdStudente = studenteService.createStudente(studente);
        return new ResponseEntity<>(createdStudente, HttpStatus.CREATED);
    }

    // Ottieni tutti gli studenti
    @GetMapping
    public ResponseEntity<List<Studente>> getAllStudenti() {
        List<Studente> studenti = studenteService.getAllStudenti();
        return new ResponseEntity<>(studenti, HttpStatus.OK);
    }

    // Ottieni uno studente per ID
    @GetMapping("/{idStudente}")
    public ResponseEntity<Studente> getStudenteById(@PathVariable Long idStudente) {
        Optional<Studente> studente = studenteService.getStudenteById(idStudente);
        return studente.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Aggiorna uno studente esistente
    @PutMapping("/{idStudente}")
    public ResponseEntity<Studente> updateStudente(@PathVariable Long idStudente, @RequestBody Studente studenteDetails) {
        Studente updatedStudente = studenteService.updateStudente(idStudente, studenteDetails);
        return new ResponseEntity<>(updatedStudente, HttpStatus.OK);
    }

    // Elimina uno studente per ID
    @DeleteMapping("/{idStudente}")
    public ResponseEntity<Void> deleteStudente(@PathVariable Long idStudente) {
        studenteService.deleteStudente(idStudente);
        return ResponseEntity.noContent().build();
    }
}
