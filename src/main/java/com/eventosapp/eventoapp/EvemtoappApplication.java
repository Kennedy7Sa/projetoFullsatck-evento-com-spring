package com.eventosapp.eventoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EvemtoappApplication {
//classe principal que roda a aplicação
	//as paginas web da aplicação como html fica na pasta resources e templates
	public static void main(String[] args) {
		SpringApplication.run(EvemtoappApplication.class, args);
	}

}
