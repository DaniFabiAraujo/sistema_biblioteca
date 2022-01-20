package com.biblioteca.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.modelo.Livro;

@Repository
public interface LivroRepositorio extends JpaRepository<Livro, Long> {

}
