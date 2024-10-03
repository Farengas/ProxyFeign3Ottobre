package com.example.ms_proxyfeign.controller;

import com.example.ms_proxyfeign.client.ScuolaFeignClient;
import com.example.ms_scuola.model.Scuola;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feign/scuole")
public class ScuolaFeignController {
    private final ScuolaFeignClient scuolaFeignClient;

    @Autowired
    public ScuolaFeignController(ScuolaFeignClient scuolaFeignClient) {
        this.scuolaFeignClient = scuolaFeignClient;
    }

    // Crea una nuova Scuola
    @PostMapping
    public ResponseEntity<Scuola> createScuola(@RequestBody Scuola scuola) {
        return scuolaFeignClient.createScuola(scuola);
    }

    // Ottieni tutte le Scuole
    @GetMapping
    public ResponseEntity<List<Scuola>> getAllScuole() {
        return scuolaFeignClient.getAllScuole();
    }

    // Ottieni una Scuola per ID
    @GetMapping("/{id}")
    public ResponseEntity<Scuola> getScuolaById(@PathVariable Long id) {
        return scuolaFeignClient.getScuolaById(id);
    }

    // Aggiorna una Scuola
    @PutMapping("/{id}")
    public ResponseEntity<Scuola> updateScuola(@PathVariable Long id, @RequestBody Scuola scuolaDetails) {
        return scuolaFeignClient.updateScuola(id, scuolaDetails);
    }

    // Elimina una Scuola
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScuola(@PathVariable Long id) {
        return scuolaFeignClient.deleteScuola(id);
    }
}
