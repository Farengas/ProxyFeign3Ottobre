package com.example.ms_genitori;

import com.example.ms_proxyfeign.client.StudenteFeignClient;
import com.example.ms_proxyfeign.model.GenericFeignClient;
import com.example.ms_proxyfeign.proxy.StudenteProxy;
import com.example.ms_studente.model.Studente;
import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

@Configuration
public class ProxyConfig {
    @Bean
    public StudenteProxy studenteProxy() {
        return new StudenteProxy(); // or use a factory method to create the instance
    }

    @Bean
    public StudenteFeignClient studenteFeignClient(){
        return  new StudenteFeignClient() {
            @Override
            public ResponseEntity createStudente(GenericFeignClient studente) {
                // implementazione del metodo
                return ResponseEntity.ok(studente);
            }

            @Override
            public ResponseEntity<List> getAllStudenti() {
                // implementazione del metodo
                return ResponseEntity.ok(Collections.emptyList());
            }

            @Override
            public ResponseEntity getStudenteById(Long idStudente) {
                // implementazione del metodo
                return ResponseEntity.ok(idStudente);
            }

            @Override
            public ResponseEntity updateStudente(Long idStudente, GenericFeignClient studenteDetails) {
                // implementazione del metodo
                return ResponseEntity.ok(studenteDetails);
            }

            @Override
            public ResponseEntity<Void> deleteStudente(Long idStudente) {
                // implementazione del metodo
                return ResponseEntity.ok().build();
            }
        };
    }


}
