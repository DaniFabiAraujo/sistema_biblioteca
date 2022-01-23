package com.biblioteca.modelo;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity

public class Reserva {

	@Id
	@Column(name = "id", nullable = false, insertable = true, updatable = true)
	private java.lang.String id = UUID.randomUUID().toString().toUpperCase();

	@ManyToOne
	@JoinColumn(name = "fk_user", nullable = false, referencedColumnName = "id", insertable = true, updatable = true)

	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "fk_livro", nullable = false, referencedColumnName = "id", insertable = true, updatable = true)

	private Livro livro;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataReserva;

	public Reserva() {

	}

	public Reserva(Livro livro) {

		this.livro = livro;
	}

	public Reserva setId(java.lang.String id) {
		this.id = id;
		return this;
	}

	public Usuario getUser() {
		return this.usuario;
	}

	public Reserva setUser(Usuario usuario) {
		this.usuario = usuario;
		return this;
	}

	public Livro getLivro() {
		return this.livro;
	}

	public Reserva setLivro(Livro livro) {
		this.livro = livro;
		return this;
	}

	public Date getDatareserva() {
		return dataReserva;
	}

	public void setData(Date dataReserva) {
		this.dataReserva = dataReserva;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Reserva object = (Reserva) obj;
		if (id != null ? !id.equals(object.id) : object.id != null)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		int result = 1;
		result = 31 * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

}