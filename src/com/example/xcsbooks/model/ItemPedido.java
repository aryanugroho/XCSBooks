package com.example.xcsbooks.model;

public class ItemPedido {
	private int quantidade;
	private Produto produto;
	private Dinheiro totalItem;
	
	public ItemPedido() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemPedido(int quantidade, Produto produto) {
		super();
		this.quantidade = quantidade;
		this.produto = produto;
	}
	public ItemPedido(int quantidade, Produto produto, Dinheiro totalItem) {
		super();
		this.quantidade = quantidade;
		this.produto = produto;
		this.totalItem = totalItem;
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
	public Dinheiro getTotalItem() {
		return totalItem;
	}
	public void setTotalItem(Dinheiro totalItem) {
		this.totalItem = totalItem;
	}
	
}
