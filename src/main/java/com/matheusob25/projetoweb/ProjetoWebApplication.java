package com.matheusob25.projetoweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class ProjetoWebApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProjetoWebApplication.class, args);
	}

}
