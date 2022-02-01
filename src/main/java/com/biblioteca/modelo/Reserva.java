package com.biblioteca.modelo;

import java.time.LocalDate;
import java.util.Objects;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity

public class Reserva {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false,  insertable = true, updatable = true)
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "livro_id", nullable = false, insertable = true, updatable = true)
	private Livro livro;

	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private LocalDate dataReserva;
	
	

	
    Reserva(Long id, Usuario usuario, Livro livro, LocalDate dataReserva) {
		this.id = id;
		this.usuario = usuario;
		this.livro = livro;
		this.dataReserva = dataReserva;
	}

	public Reserva(String usuario, String livro) {
		
	}
	

	public Reserva() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public LocalDate getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(LocalDate dataReserva) {
		this.dataReserva = dataReserva;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Reserva [usuario=" + usuario + ", livro=" + livro + ", getId()=" + getId() + ", getUsuario()="
				+ getUsuario() + ", getLivro()=" + getLivro() + ", getDataReserva()=" + getDataReserva()
				+ ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	

	}

    