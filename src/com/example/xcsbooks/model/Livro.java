package com.example.xcsbooks.model;

import android.os.Parcel;
import android.os.Parcelable;

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
	
	protected Livro(Parcel in){
		super(in);
		setIsbn(in.readString());
		setTitulo(in.readString());
		setAutor(in.readString());
		setEditora(in.readString());
	}
	
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		super.writeToParcel(dest, flags);
		dest.writeString(isbn);
		dest.writeString(titulo);
		dest.writeString(autor);
		dest.writeString(editora);
	}

	public static final Parcelable.Creator<Livro> CREATOR = new Parcelable.Creator<Livro>() {

		@Override
		public Livro createFromParcel(Parcel source) {
			return new Livro(source);
		}

		@Override
		public Livro[] newArray(int size) {
			return new Livro[size];
		}
	};
}
