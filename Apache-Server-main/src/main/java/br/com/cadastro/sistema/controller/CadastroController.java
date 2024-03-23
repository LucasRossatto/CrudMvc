package br.com.cadastro.sistema.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cadastro.sistema.exception.CadastroNotFoundException;
import br.com.cadastro.sistema.model.Cadastro;
import br.com.cadastro.sistema.service.ICadastroService;

@Controller
@RequestMapping("/cadastro")
public class CadastroController {
 
	@Autowired
	private ICadastroService service;
	@GetMapping("/")
	public String paginaInicial() {
		return "paginaInicial";
	}
	@PostMapping("/salvar")
	public String salvarAluno(@ModelAttribute Cadastro cadastro, Model model) {
		//@ModelAttribute vincula as informações dp formulário a um objeto
		service.salvarAluno(cadastro);
		//salva novamente (redundante) retorna o id do nosso pagamento
		Long id = service.salvarAluno(cadastro).getId();
		//mensagem para o usuario
		String mensagem = "Salvo com o id: " + id + "com sucesso";
		//adicionando mensagem na resposta
		model.addAttribute(mensagem);
		return "redirect:listar";
	}
	@GetMapping("/adicionar")
	public String adicionarAluno() {
		return "adicionarCadastro";
	}
	@GetMapping("/editar")
	public String editarAluno(Model model, RedirectAttributes attributes, @RequestParam Long id) {
		String page;
		try {
			Cadastro cadastro = service.buscarAlunoUnico(id);
			model.addAttribute("cadastro", cadastro);
			page = "editarCadastro";
		} catch(CadastroNotFoundException e ) {
			e.printStackTrace();
			attributes.addAttribute("message", e.getMessage());
			page = "redirect:listar";
		}
		return page;
	}
	@GetMapping("/listar") 
	public String listarAluno(@RequestParam(value = "message", required = false) String message, Model model) {
		List<Cadastro> cadastro = service.buscarTodosAluno();
		model.addAttribute("lista", cadastro);
		model.addAttribute("mensagem", message);
		return "listarCadastro";
	}
	@PostMapping("/atualizar")
	public String atualizarAluno(@ModelAttribute Cadastro cadastro, RedirectAttributes attributes) {
		service.atualizarAluno(cadastro);
		Long id = cadastro.getId();
		attributes.addAttribute("message", "Pagamento com o id: " + id + "foi atualizado");
		return "redirect:listar";
	}
	@GetMapping("/deletar")
	public String deletarAluno(@RequestParam Long id, RedirectAttributes attributes) {
	try {
		service.deletarAluno(id);
		attributes.addAttribute("message", "O pagamento foi deletado, id: " + id);
	}catch (CadastroNotFoundException e) {
		e.printStackTrace();
		attributes.addAttribute("message", e.getMessage());
	}
	return "redirect:listar";
}
}