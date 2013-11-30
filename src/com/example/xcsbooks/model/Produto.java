package com.example.xcsbooks.model;

public class Produto {
	private int codigo;
	private int quantidade;
	private Dinheiro preco;
	
	public Produto(int codigo, int quantidade, Dinheiro preco) {
		super();
		this.codigo = codigo;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public Produto() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Dinheiro getPreco() {
		return preco;
	}

	public void setPreco(Dinheiro preco) {
		this.preco = preco;
	}
	
}
