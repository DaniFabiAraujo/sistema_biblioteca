package com.biblioteca.controle;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.biblioteca.modelo.Livro;
import com.biblioteca.repositorio.LivroRepositorio;

@Controller
public class LivroController {

	private LivroRepositorio livroRepo;

	public LivroController(LivroRepositorio livroRepo) {
		this.livroRepo = livroRepo;
	}

	@GetMapping("/gerenciar/livros")
	public String livros(Model model) {
		model.addAttribute("listaLivros", livroRepo.findAll());
		return "/gerenciar/livros/livros";
	}

	@GetMapping("/gerenciar/livros/novo")
	public String novoLivro(@ModelAttribute("livro") Livro livro) {
		return "/gerenciar/livros/form";
	}

	@PostMapping("/gerenciar/livros/salvar")
	public String salvarlivro(@ModelAttribute("livro") Livro livro) {
		livroRepo.save(livro);
		return "redirect:/gerenciar/livros";
	}

	@GetMapping("/gerenciar/livros/{id}")
	public String alterarLivro(@PathVariable("id") long id, Model model) {
		Optional<Livro> livroOpt = livroRepo.findById(id);
		if (livroOpt.isEmpty()) {
			throw new IllegalArgumentException("Livro não existe!");
		}

		model.addAttribute("livro", livroOpt.get());
		return "/gerenciar/livros/form";
	}

	@GetMapping("/gerenciar/livros/excluir/{id}")
	public String excluirLivro(@PathVariable("id") long id) {
		Optional<Livro> livroOpt = livroRepo.findById(id);
		if (livroOpt.isEmpty()) {
			throw new IllegalArgumentException("Livro não existe!.");
		}

		livroRepo.delete(livroOpt.get());
		return "redirect:/gerenciar/livros";

	}
}
