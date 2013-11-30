package com.example.xcsbooks.model;

public class Livro extends Produto {
	private String isbn;
	private String titulo;
	private String autor;
	private String editora;
	
	public Livro(String isbn, String titulo, String autor, String editora) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.editora = editora;
	}

	public Livro() {
		super();
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}
	
	
}
