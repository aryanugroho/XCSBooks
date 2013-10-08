package model;

import java.util.Date;

public class LivroUsado extends Produto {
	private Livro livro;
	private String estado;
	private int porcentagemVenda;
	private Date dataCadastro;
	private String horaCadastro;
	
	public LivroUsado(int codigo, int quantidade, double preco, Livro livro,
			String estado, int porcentagemVenda, Date dataCadastro,
			String horaCadastro) {
		super(codigo, quantidade, preco);
		this.livro = livro;
		this.estado = estado;
		this.porcentagemVenda = porcentagemVenda;
		this.dataCadastro = dataCadastro;
		this.horaCadastro = horaCadastro;
	}
	
	public LivroUsado(int codigo, int quantidade, double preco, String isbn,
			String titulo, String autor, String editora, String estado,
			int porcentagemVenda, Date dataCadastro, String horaCadastro) {
		super(codigo, quantidade, preco);
		this.livro = new Livro(isbn,titulo,autor,editora);
		this.estado = estado;
		this.porcentagemVenda = porcentagemVenda;
		this.dataCadastro = dataCadastro;
		this.horaCadastro = horaCadastro;
	}

	public LivroUsado() {
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
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getPorcentagemVenda() {
		return porcentagemVenda;
	}

	public void setPorcentagemVenda(int porcentagemVenda) {
		this.porcentagemVenda = porcentagemVenda;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getHoraCadastro() {
		return horaCadastro;
	}

	public void setHoraCadastro(String horaCadastro) {
		this.horaCadastro = horaCadastro;
	}
	
}
