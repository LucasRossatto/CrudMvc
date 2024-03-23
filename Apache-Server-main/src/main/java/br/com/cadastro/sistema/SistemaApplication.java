package br.com.cadastro.sistema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Anottation => Indica que é um projeto SpringBoot
@SpringBootApplication
public class SistemaApplication {

	public static void main(String[] args) {
		//Ele cria um contexto que é uma aplicação Spring 
		// Varredura, das classes antes de iniciar
		//Inicia a aplicação
		SpringApplication.run(SistemaApplication.class, args);
	}

}
