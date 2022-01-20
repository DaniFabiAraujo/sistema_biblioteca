package com.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.biblioteca.repositorio.LivroRepositorio;

@Controller
public class LivroController {
	
	
	private LivroRepositorio livroRepo;
	
	public LivroController (LivroRepositorio livroRepo) {
		this.livroRepo = livroRepo;
	}
	
	@GetMapping("/livros")
	public String livros(Model model) {
		model.addAttribute("listaLivros", livroRepo.findAll());
		return "/livros/livros";
	}
	


}
