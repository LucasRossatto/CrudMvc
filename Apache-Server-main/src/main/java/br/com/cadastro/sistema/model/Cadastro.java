package br.com.cadastro.sistema.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Entidade indicando que é Objeto
@Data // Gera automaticamente o getts and setters
@NoArgsConstructor //Nao recebe argumentos
public class Cadastro {
	
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private double idade;
	private String curso;

}
