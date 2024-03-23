package br.com.cadastro.sistema.exception;

public class CadastroNotFoundException extends RuntimeException {

	// Identificador de versão
	// Classe Serializable
	// Final a variável é definida uma unica vez
	// long => Um int com maior quantidade de numeros disponíveis
	private static final long serialVersionUID = 1L;
	
	//Construtor vazio
	public CadastroNotFoundException() {
		super();
	}
	
	//Construtor com uma mensagem
	public CadastroNotFoundException(String mensagemCustomizada) {
		super(mensagemCustomizada);
	}
}
