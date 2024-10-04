package com.example.ms_proxyfeign.client;




import com.example.ms_proxyfeign.model.GenericFeignClient;
import com.example.ms_studente.model.Studente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "studente-feign-client", url = "http://localhost:8084")
public interface StudenteFeignClient extends GenericFeignClient {

    @PostMapping("/api/studenti")
    ResponseEntity<Studente> createStudente(@RequestBody Studente studente);

    @GetMapping("/api/studenti")
    ResponseEntity<List<Studente>> getAllStudenti();

    @GetMapping("/api/studenti/{idStudente}")
    ResponseEntity<Studente> getStudenteById(@PathVariable("idStudente") Long idStudente);

    @PutMapping("/api/studenti/{idStudente}")
    ResponseEntity<Studente> updateStudente(
            @PathVariable("idStudente") Long idStudente,
            @RequestBody Studente studenteDetails
    );

    @DeleteMapping("/api/studenti/{idStudente}")
    ResponseEntity<Void> deleteStudente(@PathVariable("idStudente") Long idStudente);

}
