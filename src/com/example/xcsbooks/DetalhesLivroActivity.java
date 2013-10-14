package com.example.xcsbooks;

import java.util.List;

import model.LivroNovo;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import control.JSONParser;

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
		
		//Obtém o objeto livro passado
		Intent i = getIntent();
		livro = (LivroNovo) i.getParcelableExtra(BuscarActivity.KEY_LIVRO);
		
		mTxtTituloLivro.setText(livro.getTitulo());
		mTxtAutorLivro.setText(livro.getAutor());
		mTxtEditoraLivro.setText(livro.getEditora());
		mTxtPrecoLivro.setText(String.valueOf(livro.getPreco()));
		mTxtIsbaLivro.setText(livro.getIsbn());
		
		mBtnAdicionarCarrinho.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Obter livros do carrinho
				SharedPreferences prefs = getSharedPreferences("CARRINHO", MODE_PRIVATE);
				String carrinho = prefs.getString("LIVROS", JSONParser.DEFAULT_LIVROS);
				List<LivroNovo> list = JSONParser.LivroFromJSON(carrinho);
				list.add(livro);
				carrinho = JSONParser.LivroToJSON(list);
				SharedPreferences.Editor editor = prefs.edit();
				editor.putString("LIVROS", carrinho).commit();
				
				Toast.makeText(getApplicationContext(), "Livro adicionado ao carrinho", Toast.LENGTH_LONG).show();
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
