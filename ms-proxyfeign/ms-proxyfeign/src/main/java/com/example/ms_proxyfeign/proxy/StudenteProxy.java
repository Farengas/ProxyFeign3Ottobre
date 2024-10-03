package com.example.ms_proxyfeign.proxy;

import com.example.ms_proxyfeign.client.StudenteFeignClient;
import com.example.ms_proxyfeign.model.FeignProxy;
import com.example.ms_proxyfeign.model.GenericFeignClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Component
public class StudenteProxy<T extends GenericFeignClient<T>> extends FeignProxy {

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
}
