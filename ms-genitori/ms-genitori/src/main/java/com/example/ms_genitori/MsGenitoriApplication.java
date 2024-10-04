package com.example.ms_genitori;

import com.example.ms_proxyfeign.client.StudenteFeignClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
public class MsGenitoriApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsGenitoriApplication.class, args);

	}

}
