package br.com.pagamento.sistema.exception;

public class PagamentoNotFoundException extends RuntimeException {

	// Identificador de versão
	// Classe Serializable
	// Final a variável é definida uma unica vez
	// long => Um int com maior quantidade de numeros disponíveis
	private static final long serialVersionUID = 1L;
	
	//Construtor vazio
	public PagamentoNotFoundException() {
		super();
	}
	
	//Construtor com uma mensagem
	public PagamentoNotFoundException(String mensagemCustomizada) {
		super(mensagemCustomizada);
	}
}
