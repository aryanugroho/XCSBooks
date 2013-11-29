package com.example.xcsbooks.model;

import java.util.List;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint("ParcelCreator")
public class Pedido implements Parcelable {
	private int id;
	private String datahora;
	private String estado;
	private Double total;
	private List<Produto> produtos; 
	
	
	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Pedido(int id, String datahora, String estado, Double total) {
		super();
		this.id = id;
		this.datahora = datahora;
		this.estado = estado;
		this.total = total;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDatahora() {
		return datahora;
	}
	public void setDatahora(String datahora) {
		this.datahora = datahora;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeInt(getId());
		dest.writeString(getDatahora());
		dest.writeString(getEstado());
		dest.writeDouble(getTotal());
	}
	
	public static final Parcelable.Creator<Pedido> CREATOR = new Parcelable.Creator<Pedido>() {

		@Override
		public Pedido createFromParcel(Parcel source) {
			return new Pedido(source);
		}

		@Override
		public Pedido[] newArray(int size) {
			return new Pedido[size];
		}
	};
	
	private Pedido(Parcel in){
		setId(in.readInt());
		setDatahora(in.readString());
		setEstado(in.readString());
		setTotal(in.readDouble());
	}
	
}
