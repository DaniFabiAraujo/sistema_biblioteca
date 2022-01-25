package com.biblioteca.controle;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.biblioteca.modelo.Reserva;
import com.biblioteca.repositorio.ReservaRepositorio;



@Controller
public class ReservaController {

	private ReservaRepositorio reservaRepo;

	public ReservaController(ReservaRepositorio reservaRepo) {
		this.reservaRepo = reservaRepo;
	}
//
//	@GetMapping("/gerenciar/reservas")
//	public String reservas(Model model) {
//		model.addAttribute("listaLivros", reservaRepo.findAll());
//		return "/gerenciar/reservas/reservas";
//	}

	@GetMapping("/gerenciar/reservas/novo")
	public String novaReserva(@ModelAttribute("reserva") Reserva reserva) {
		return "/gerenciar/reservas/form";
	}

	@PostMapping("/gerenciar/reserva/salvar")
	public String salvarreserva(@ModelAttribute("reserva") Reserva reserva) {
		reservaRepo.save(reserva);
		return "redirect:/gerenciar/reservas";
	}

	@GetMapping("/gerenciar/reservas/{id}")
	public String alterarLivro(@PathVariable("id") long id, Model model) {
		Optional<Reserva> reservaOpt = reservaRepo.findById(id);
		if (reservaOpt.isEmpty()) {
			throw new IllegalArgumentException("Reserva não existe!");
		}

		model.addAttribute("reserva", reservaOpt.get());
		return "/gerenciar/reservas/form";
	}

	@GetMapping("/gerenciar/reservas/excluir/{id}")
	public String excluirLivro(@PathVariable("id") long id) {
		Optional<Reserva> reservaOpt = reservaRepo.findById(id);
		if (reservaOpt.isEmpty()) {
			throw new IllegalArgumentException("Reserva não existe!.");
		}

		reservaRepo.delete(reservaOpt.get());
		return "redirect:/gerenciar/reservas";

	}
}
