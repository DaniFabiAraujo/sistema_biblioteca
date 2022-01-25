package com.biblioteca;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.biblioteca.modelo.Livro;
import com.biblioteca.modelo.Reserva;
import com.biblioteca.modelo.Role;
import com.biblioteca.modelo.Usuario;
import com.biblioteca.repositorio.LivroRepositorio;
import com.biblioteca.repositorio.ReservaRepositorio;
import com.biblioteca.repositorio.UsuarioRepositorio;

@Component
@Transactional
public class PopulaBD implements CommandLineRunner {

	@Autowired
	private LivroRepositorio livroRepo;

	@Autowired
	private UsuarioRepositorio usuarioRepo;
    
	@Autowired
	private ReservaRepositorio reservaRepo;

	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {
		Livro l1 = new Livro("A revolução dos bichos");
		l1.setIsbn("8535909559");
		l1.setAutor("George Orwell");
		l1.setEditora("Editora Milênio");
		l1.setAnoPublicacao(2007);

		Livro l2 = new Livro("Admirável Mundo Novo");
		l2.setIsbn("8525056006");
		l2.setAutor("Aldous Huxley");
		l2.setEditora("Editora Contemporânea");
		l2.setAnoPublicacao(2010);

		Livro l3 = new Livro("Dom Casmurro");
		l3.setIsbn("859431860X");
		l3.setAutor("Machado de Assis");
		l3.setEditora("Editora Tempo");
		l3.setAnoPublicacao(2019);

		livroRepo.save(l1);
		livroRepo.save(l2);
		livroRepo.save(l3);

		Usuario u1 = new Usuario("daniel", passwordEncoder.encode("123"));
		u1.setRole(Role.ADMIN.getNome());

		Usuario u2 = new Usuario("user", passwordEncoder.encode("user"));
		u2.setRole(Role.USER.getNome());

		Usuario u3 = new Usuario("cliente", passwordEncoder.encode("cliente"));
		u3.setRole(Role.CUSTOMER.getNome());

		usuarioRepo.save(u1);
		usuarioRepo.save(u2);
		usuarioRepo.save(u3);
		
		Reserva r1 = new Reserva();
	
		r1.setUsuario(u1);
		r1.setLivro(l3);
		r1.setDataReserva(LocalDate.of(2020, 1, 27));

		reservaRepo.save(r1);
	}
}