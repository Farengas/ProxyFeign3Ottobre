package com.example.ms_proxyfeign.model;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import static lombok.Lombok.checkNotNull;

@Log4j2
public abstract class FeignProxy <T extends GenericFeignClient>{
    // Make getFeignClient generic
    protected abstract T getFeignClient();

    protected abstract String getOriginEngagedName();

    protected Boolean validateSimpleRestResponse(ResponseEntity<?> response) {
        return response != null && response.getBody() != null;
    }

    // Methods with generics to avoid casting
    protected <R> ResponseEntity<R> performGet(String endpoint, Class<R> responseClass, HttpHeaders headers) {
        checkNotNull(endpoint, "[Proxy:performGet] => endpoint");
        R result = (R) getFeignClient().performGet(endpoint, headers);
        return ResponseEntity.ok(result);
    }

    protected <R, O> ResponseEntity<R> performPost(String endpoint, O body, Class<R> responseClass) {
        checkNotNull(endpoint, "[Proxy:performPost] => endpoint");
        R result = (R) getFeignClient().performPost(endpoint, body);
        return ResponseEntity.ok(result);
    }

    protected <R, O> ResponseEntity<R> performPut(String endpoint, O body, Class<R> responseClass) {
        checkNotNull(endpoint, "[Proxy:performPut] => endpoint");
        R result = (R) getFeignClient().performPut(endpoint, body);
        return ResponseEntity.ok(result);
    }

    protected <R, O> ResponseEntity<R> performPatch(String endpoint, O body, Class<R> responseClass) {
        checkNotNull(endpoint, "[Proxy:performPatch] => endpoint");
        R result = (R) getFeignClient().performPatch(endpoint, body);
        return ResponseEntity.ok(result);
    }

    protected <R> ResponseEntity<R> performDelete(String endpoint, Class<R> responseClass, HttpHeaders headers) {
        checkNotNull(endpoint, "[Proxy:performDelete] => endpoint");
        R result = (R) getFeignClient().performDelete(endpoint, headers);
        return ResponseEntity.ok(result);
    }

/*
    protected abstract GenericFeignClient getFeignClient();

    protected abstract String getOriginEngagedName();


    protected Boolean validateSimpleRestResponse(ResponseEntity<?> response) {
        return response != null && response.getBody() != null;
    }

    // Metodo per eseguire una chiamata GET
    protected <T> ResponseEntity<T> performGet(String endpoint, Class<T> responseClass, HttpHeaders headers) {
        checkNotNull(endpoint, "[Proxy:performGet] => endpoint");
        T result = (T) getFeignClient().performGet(endpoint, headers);
        return ResponseEntity.ok(result);
    }

    // Metodo per eseguire una chiamata POST
    protected <T, O> ResponseEntity<T> performPost(String endpoint, O body, Class<T> responseClass) {
        checkNotNull(endpoint, "[Proxy:performPost] => endpoint");
        T result = (T) getFeignClient().performPost(endpoint, body);
        return ResponseEntity.ok(result);
    }

    // Metodo per eseguire una chiamata PUT
    protected <T, O> ResponseEntity<T> performPut(String endpoint, O body, Class<T> responseClass) {
        checkNotNull(endpoint, "[Proxy:performPut] => endpoint");
        T result = (T) getFeignClient().performPut(endpoint, body);
        return ResponseEntity.ok(result);
    }

    // Metodo per eseguire una chiamata PATCH
    protected <T, O> ResponseEntity<T> performPatch(String endpoint, O body, Class<T> responseClass) {
        checkNotNull(endpoint, "[Proxy:performPatch] => endpoint");
        T result = (T) getFeignClient().performPatch(endpoint, body);
        return ResponseEntity.ok(result);
    }

    // Metodo per eseguire una chiamata DELETE
    protected <T> ResponseEntity<T> performDelete(String endpoint, Class<T> responseClass, HttpHeaders headers) {
        checkNotNull(endpoint, "[Proxy:performDelete] => endpoint");
        T result = (T) getFeignClient().performDelete(endpoint, headers);
        return ResponseEntity.ok(result);
    }

 */
}
