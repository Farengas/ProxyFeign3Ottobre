package com.example.ms_proxyfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsProxyfeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProxyfeignApplication.class, args);
	}

}
