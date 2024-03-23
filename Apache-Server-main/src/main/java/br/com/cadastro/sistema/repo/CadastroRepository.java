package br.com.cadastro.sistema.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cadastro.sistema.model.Cadastro;

public interface CadastroRepository extends JpaRepository<Cadastro,Long> {

}
