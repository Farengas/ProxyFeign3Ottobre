package com.example.ms_genitori.config;

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




}
