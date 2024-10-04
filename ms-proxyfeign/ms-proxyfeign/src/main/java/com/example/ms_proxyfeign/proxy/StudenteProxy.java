package com.example.ms_proxyfeign.proxy;

import com.example.ms_proxyfeign.client.StudenteFeignClient;
import com.example.ms_proxyfeign.model.FeignProxy;
import com.example.ms_proxyfeign.model.GenericFeignClient;

import com.example.ms_studente.model.Studente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Component
public class StudenteProxy extends FeignProxy<StudenteFeignClient> {

    @Autowired
    @Lazy
    private StudenteFeignClient studenteFeignClient;

    @Override
    protected StudenteFeignClient getFeignClient() {
        // Returning StudenteFeignClient directly without casting
        return studenteFeignClient;
    }

    @Override
    protected String getOriginEngagedName() {
        return "ms-studente";
    }

    // Create a new Studente
    public Studente createStudente(Studente studente) {
        return studenteFeignClient.createStudente(studente).getBody();
    }

    // Get all Studenti
    public List<Studente> getAllStudenti() {
        return studenteFeignClient.getAllStudenti().getBody();
    }

    // Get Studente by ID
    public Optional<Studente> getStudenteById(Long idStudente) {
        return Optional.ofNullable(studenteFeignClient.getStudenteById(idStudente).getBody());
    }

    // Update an existing Studente
    public Studente updateStudente(Long idStudente, Studente studenteDetails) {
        return studenteFeignClient.updateStudente(idStudente, studenteDetails).getBody();
    }

    // Delete Studente by ID
    public void deleteStudente(Long idStudente) {
        studenteFeignClient.deleteStudente(idStudente);
    }
/*
    @Autowired
    @Lazy
    private StudenteFeignClient<T> studenteFeignClient;

    @Override
    protected GenericFeignClient<T> getFeignClient() {
        return (GenericFeignClient<T>) studenteFeignClient;
    }

    @Override
    protected String getOriginEngagedName() {
        return "ms-studente";
    }

    public T createStudente(@RequestBody T studente) {
        return studenteFeignClient.createStudente(studente).getBody();
    }

    public List<T> getAllStudenti() {
        return studenteFeignClient.getAllStudenti().getBody();
    }

    public Optional<T> getStudenteById(Long idStudente) {
        return Optional.ofNullable(studenteFeignClient.getStudenteById(idStudente).getBody());
    }

    public T updateStudente(Long idStudente, @RequestBody T studenteDetails) {
        return studenteFeignClient.updateStudente(idStudente, studenteDetails).getBody();
    }

    public void deleteStudente(Long idStudente) {
        studenteFeignClient.deleteStudente(idStudente);
    }

 */
}
