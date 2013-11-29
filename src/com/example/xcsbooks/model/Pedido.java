package com.example.xcsbooks.model;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint("ParcelCreator")
public class Pedido implements Parcelable {
	private int codigo;
	private String data;
	private Double preco;
	private String status;
	
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeInt(getCodigo());
		dest.writeString(getData());
		dest.writeDouble(getPreco());
		dest.writeString(getStatus());
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
		setCodigo(in.readInt());
		setData(in.readString());
		setPreco(in.readDouble());
		setStatus(in.readString());
	}
	
}
