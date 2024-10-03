package com.example.ms_proxyfeign.client;

import com.example.ms_professore.model.Professore;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "professore-feign-client", url = "http://localhost:8081")
public interface ProfessoreFeignClient {
    @PostMapping("/api/professori")
    ResponseEntity<Professore> createProfessore(@RequestBody Professore professore);

    @GetMapping("/api/professori")
    ResponseEntity<List<Professore>> getAllProfessori();

    @GetMapping("/api/professori/{id}")
    ResponseEntity<Professore> getProfessoreById(@PathVariable("id") Long id);

    @PutMapping("/api/professori/{id}")
    ResponseEntity<Professore> updateProfessore(@PathVariable("id") Long id, @RequestBody Professore professoreDetails);

    @DeleteMapping("/api/professori/{id}")
    void deleteProfessore(@PathVariable("id") Long id);
}
