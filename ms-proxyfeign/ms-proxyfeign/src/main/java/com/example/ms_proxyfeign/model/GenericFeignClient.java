package com.example.ms_proxyfeign.model;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "generic-feign-client")
public interface GenericFeignClient<T> {
    @GetMapping("/{endpoint}")
    <T> T performGet(@PathVariable("endpoint") String endpoint, HttpHeaders headers);

    @PostMapping("/{endpoint}")
    <T, O> T performPost(@PathVariable("endpoint") String endpoint, @RequestBody O body);

    @PutMapping("/{endpoint}")
    <T, O> T performPut(@PathVariable("endpoint") String endpoint, @RequestBody O body);

    @PatchMapping("/{endpoint}")
    <T, O> T performPatch(@PathVariable("endpoint") String endpoint, @RequestBody O body);

    @DeleteMapping("/{endpoint}")
    <T> T performDelete(@PathVariable("endpoint") String endpoint, HttpHeaders headers);

}
