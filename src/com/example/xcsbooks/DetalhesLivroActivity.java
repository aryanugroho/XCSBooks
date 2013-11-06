package com.example.xcsbooks;

import java.util.List;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xcsbooks.control.GetBookCover;
import com.example.xcsbooks.control.JSONParser;
import com.example.xcsbooks.model.Dinheiro;
import com.example.xcsbooks.model.LivroNovo;

public class DetalhesLivroActivity extends BaseActivity {
	
	private TextView mTxtTituloLivro;
	private TextView mTxtAutorLivro;
	private TextView mTxtEditoraLivro;
	private TextView mTxtPrecoLivro;
	private TextView mTxtIsbaLivro;
	private Button mBtnAdicionarCarrinho;
	private Button mBtnComprar;
	private LivroNovo livro;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalhes_livro);
		
		mTxtTituloLivro = (TextView) findViewById(R.id.detalheLivro_txtTitulo);
		mTxtAutorLivro = (TextView) findViewById(R.id.detalheLivro_txtAutor);
		mTxtEditoraLivro = (TextView) findViewById(R.id.detalheLivro_txtEditora);
		mTxtPrecoLivro = (TextView) findViewById(R.id.detalheLivro_txtPreco);
		mTxtIsbaLivro = (TextView) findViewById(R.id.detalheLivro_txtIsbn);
		mBtnAdicionarCarrinho = (Button) findViewById(R.id.detalheLivro_btnAdicionarCarrinho);
		mBtnComprar = (Button) findViewById(R.id.detalheLivro_btnComprar);
		ImageView im = (ImageView) findViewById(R.id.detalheLivro_imagemLivro);
		
		//Obtem o objeto livro passado
		Intent i = getIntent();
		Resources r = getResources();
		
		livro = (LivroNovo) i.getParcelableExtra(BuscarActivity.KEY_LIVRO);
		
		im.setImageBitmap(GetBookCover.getCover(livro.getIsbn()));
		mTxtTituloLivro.setText(livro.getTitulo());
		mTxtAutorLivro.setText(r.getString(R.string.autor) + " " + livro.getAutor());
		mTxtEditoraLivro.setText(r.getString(R.string.editora) + " " + livro.getEditora());
		mTxtPrecoLivro.setText(r.getString(R.string.preco) + new Dinheiro(livro.getPreco()).toString());
		mTxtIsbaLivro.setText(r.getString(R.string.isbn) + " " + livro.getIsbn());
		
		mBtnAdicionarCarrinho.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Obter livros do carrinho
				SharedPreferences prefs = getSharedPreferences("CARRINHO", MODE_PRIVATE);
				String carrinho = prefs.getString("LIVROS", JSONParser.DEFAULT_LIVROS);
				List<LivroNovo> list = JSONParser.LivroFromJSON(carrinho);
				
				boolean add = true;
				for(LivroNovo l : list){
					if(l.getCodigo() == livro.getCodigo())
						add = false;
				}
				
				if(add)
					list.add(livro);
				
				carrinho = JSONParser.LivroToJSON(list);
				SharedPreferences.Editor editor = prefs.edit();
				editor.putString("LIVROS", carrinho);
				if(add){
					editor.putInt("LIVROS" + livro.getCodigo(), 1);
				} else {
					int prev = prefs.getInt("LIVROS" + livro.getCodigo(), 1);
					editor.remove("LIVROS" + livro.getCodigo()).putInt("LIVROS" + livro.getCodigo(), prev + 1);
					//Toast.makeText(getApplicationContext(), ""+prev, Toast.LENGTH_LONG).show();
				}
				editor.commit();
				
				Toast.makeText(getApplicationContext(), "Livro adicionado ao carrinho", Toast.LENGTH_SHORT).show();
			}
		});
		
		mBtnComprar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
			}
		});
	
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		return super.onOptionsItemSelected(item);
	}
}
