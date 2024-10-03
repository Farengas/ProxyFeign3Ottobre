package com.example.ms_proxyfeign.client;

import com.example.ms_proxyfeign.model.GenericFeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "studente-feign-client", url = "http://localhost:8084")
public interface StudenteFeignClient<T extends GenericFeignClient<T>> {

    @PostMapping("/api/studenti")
    ResponseEntity<T> createStudente(@RequestBody T studente);

    @GetMapping("/api/studenti")
    ResponseEntity<List<T>> getAllStudenti();

    @GetMapping("/api/studenti/{idStudente}")
    ResponseEntity<T> getStudenteById(@PathVariable("idStudente") Long idStudente);

    @PutMapping("/api/studenti/{idStudente}")
    ResponseEntity<T> updateStudente(
            @PathVariable("idStudente") Long idStudente,
            @RequestBody T studenteDetails
    );

    @DeleteMapping("/api/studenti/{idStudente}")
    ResponseEntity<Void> deleteStudente(@PathVariable("idStudente") Long idStudente);

}
