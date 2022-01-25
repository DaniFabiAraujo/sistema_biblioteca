package com.biblioteca.dtos;

public class ReservaListaDTO {
	
		private Long id;
		private String usuario;
		private String livro;
		public ReservaListaDTO(Long id, String usuario, String livro) {
			
			this.id = id;
			this.usuario = usuario;
			this.livro = livro;
		
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getUsuario() {
			return usuario;
		}
		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}
		public String getLivro() {
			return livro;
		}
		public void setLivro(String livro) {
			this.livro = livro;
		}
		
		
		
	    
}