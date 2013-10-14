package model;

import android.os.Parcel;
import android.os.Parcelable;

public class LivroNovo extends Produto implements Parcelable {
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

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(getCodigo());
		dest.writeInt(getQuantidade());
		dest.writeDouble(getPreco());
		dest.writeString(getIsbn());
		dest.writeString(getTitulo());
		dest.writeString(getAutor());
		dest.writeString(getEditora());
	}

	public static final Parcelable.Creator<LivroNovo> CREATOR = new Parcelable.Creator<LivroNovo>() {

		@Override
		public LivroNovo createFromParcel(Parcel source) {
			return new LivroNovo(source);
		}

		@Override
		public LivroNovo[] newArray(int size) {
			return new LivroNovo[size];
		}
	};
	
	private LivroNovo(Parcel in){
		setCodigo(in.readInt());
		setQuantidade(in.readInt());
		setPreco(in.readDouble());
		livro = new Livro(in.readString(),in.readString(),in.readString(),in.readString());
	}
	
}
