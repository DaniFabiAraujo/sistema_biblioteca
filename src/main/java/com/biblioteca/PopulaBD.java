//package com.biblioteca;
//
//
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import com.biblioteca.modelo.Livro;
//import com.biblioteca.repositorio.LivroRepositorio;
//
//@Transactional
//@Component
//public class PopulaBD implements CommandLineRunner {
//	
//	@Autowired
//	private  LivroRepositorio livroRepo;
//
//
//	@Override
//	public void run(String... args) throws Exception {
//		Livro l1 = new Livro("A revolução dos bichos");
//		l1.setIsbn("8535909559");
//		l1.setAutor("George Orwell");
//		l1.setAnoPublicacao(2007);
//		
//		
//		Livro l2 = new Livro("Admirável Mundo Novo");
//		l2.setIsbn("8525056006");
//		l2.setAutor("Aldous Huxley");
//		l2.setAnoPublicacao(2010);
//		
//		Livro l3 = new Livro("Dom Casmurro");
//		l3.setIsbn("859431860X");
//		l3.setAutor("Machado de Assis");
//		l3.setAnoPublicacao(2019);
//		
//
//		livroRepo.save(l1);
//		livroRepo.save(l2);
//		livroRepo.save(l3);
//		
//	}		
//}
