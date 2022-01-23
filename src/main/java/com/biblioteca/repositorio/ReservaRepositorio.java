package com.biblioteca.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.modelo.Reserva;

@Repository
public interface ReservaRepositorio extends JpaRepository<Reserva, Long> {

	
}
