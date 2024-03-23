package br.com.cadastro.sistema.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastro.sistema.exception.CadastroNotFoundException;
import br.com.cadastro.sistema.model.Cadastro;
import br.com.cadastro.sistema.repo.CadastroRepository;
import br.com.cadastro.sistema.service.ICadastroService;

@Service
public class CadastroServiceImpl implements ICadastroService {
	@Autowired
	private CadastroRepository repo;
	
	@Override
	public Cadastro salvarAluno(Cadastro cadastro) {
		return repo.save(cadastro);
	}
	
	@Override
	public List<Cadastro> buscarTodosAluno(){
		return repo.findAll();
	}
	
	@Override
		public Cadastro buscarAlunoUnico(Long id) {
			Optional<Cadastro> opt = repo.findById(id);
			if(opt.isPresent()) {
				return opt.get();
			}else {
				throw new CadastroNotFoundException("o ID:" + id + "não encontrado");
			}
		}
		
	@Override
	public void deletarAluno(Long id) {
		repo.delete(buscarAlunoUnico(id));
	}
	
	@Override
		public void atualizarAluno(Cadastro cadastro) {
			repo.save(cadastro);
		}
	
}
