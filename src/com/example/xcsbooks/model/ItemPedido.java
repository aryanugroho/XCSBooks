package com.example.xcsbooks.model;

public class ItemPedido {
	private int quantidade;
	private Produto produto;
	
	public ItemPedido() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemPedido(int quantidade, Produto produto) {
		super();
		this.quantidade = quantidade;
		this.produto = produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}
