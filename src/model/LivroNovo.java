package model;

public class LivroNovo extends Produto {
	private Livro livro;

	public LivroNovo(int codigo, int quantidade, double preco, Livro livro) {
		super(codigo, quantidade, preco);
		this.livro = livro;
	}
	
	public LivroNovo(int codigo, int quantidade, double preco, String isbn,
			String titulo, String autor, String editora) {
		super(codigo, quantidade, preco);
		this.livro = new Livro(isbn,titulo,autor,editora);
	}

	public LivroNovo() {
		super();
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public String getIsbn() {
		return livro.getIsbn();
	}
	
	public void setIsbn(String isbn) {
		this.livro.setIsbn(isbn);
	}
	
	public String getTitulo() {
		return livro.getTitulo();
	}
	
	public void setTitulo(String titulo) {
		this.livro.setTitulo(titulo);
	}
	
	public String getAutor() {
		return livro.getAutor();
	}
	
	public void setAutor(String autor) {
		this.livro.setAutor(autor);
	}
	
	public String getEditora() {
		return livro.getEditora();
	}
	
	public void setEditora(String editora) {
		this.livro.setEditora(editora);
	}
}
