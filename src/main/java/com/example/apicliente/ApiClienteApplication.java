package com.example.apicliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ApiClienteApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiClienteApplication.class, args);
	}

}
