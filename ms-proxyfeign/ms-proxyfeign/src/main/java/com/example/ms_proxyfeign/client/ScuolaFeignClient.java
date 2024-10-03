package com.example.ms_proxyfeign.client;

import com.example.ms_scuola.model.Scuola;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "scuole-feign-client", url = "http://localhost:8080")
public interface ScuolaFeignClient {
    // Crea una nuova Scuola
    @PostMapping("/api/scuole")
    ResponseEntity<Scuola> createScuola(@RequestBody Scuola scuola);

    // Ottieni tutte le Scuole
    @GetMapping("/api/scuole")
    ResponseEntity<List<Scuola>> getAllScuole();

    // Ottieni una Scuola per ID
    @GetMapping("/api/scuole/{id}")
    ResponseEntity<Scuola> getScuolaById(@PathVariable("id") Long id);

    // Aggiorna una Scuola
    @PutMapping("/api/scuole/{id}")
    ResponseEntity<Scuola> updateScuola(@PathVariable("id") Long id, @RequestBody Scuola scuolaDetails);

    // Elimina una Scuola
    @DeleteMapping("/api/scuole/{id}")
    ResponseEntity<Void> deleteScuola(@PathVariable("id") Long id);
}
