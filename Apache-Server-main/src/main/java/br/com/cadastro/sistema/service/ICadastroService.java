package br.com.cadastro.sistema.service;

import java.util.List;

import br.com.cadastro.sistema.model.Cadastro;


public interface ICadastroService {
		
		public Cadastro salvarAluno(Cadastro cadastro);
		
		public List<Cadastro> buscarTodosAluno();
		
		public Cadastro buscarAlunoUnico(Long id);
		
		public void deletarAluno(Long id);
		
		public void atualizarAluno(Cadastro cadastro);
	
	
}
