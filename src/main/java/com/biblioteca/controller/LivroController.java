package com.biblioteca.controller;

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

	@GetMapping("/livros")
	public String livros(Model model) {
		model.addAttribute("listaLivros", livroRepo.findAll());
		return "/livros/livros";
	}

	@GetMapping("/livros/novo")
	public String novoLivro(@ModelAttribute("livro") Livro livro) {
		return "/livros/form";
	}

	@PostMapping("/livros/salvar")
	public String salvarlivro(@ModelAttribute("livro") Livro livro) {
		livroRepo.save(livro);
		return "redirect:/livros";
	}

	@GetMapping("/livros/{id}")
	public String alterarPessoa(@PathVariable("id") long id, Model model) {
		Optional<Livro> livroOpt = livroRepo.findById(id);
		if (livroOpt.isEmpty()) {
			throw new IllegalArgumentException("Livro não existe!");
		}

		model.addAttribute("livro", livroOpt.get());
		return "/livros/form";
	}

	@GetMapping("/livros/excluir/{id}")
	public String excluirPessoa(@PathVariable("id") long id) {
		Optional<Livro> livroOpt = livroRepo.findById(id);
		if (livroOpt.isEmpty()) {
			throw new IllegalArgumentException("Livro não existe!.");
		}

		livroRepo.delete(livroOpt.get());
		return "redirect:/livros";

	}
}
