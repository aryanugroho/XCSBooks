package com.example.xcsbooks.model;

import java.util.Date;

public class LivroUsado extends LivroNovo {
	private String estado;
	private int porcentagemVenda;
	private Date dataCadastro;
	private String horaCadastro;
	
	public LivroUsado() {
		super();
	}

	public LivroUsado(int codigo, int quantidade, Dinheiro preco, String isbn,
			String titulo, String autor, String editora, String estado,
			int porcentagemVenda, Date dataCadastro, String horaCadastro) {
		super(codigo, quantidade, preco, isbn, titulo, autor, editora);
		this.estado = estado;
		this.porcentagemVenda = porcentagemVenda;
		this.dataCadastro = dataCadastro;
		this.horaCadastro = horaCadastro;
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
