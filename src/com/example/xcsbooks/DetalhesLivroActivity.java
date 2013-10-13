package com.example.xcsbooks;

import control.TestListBooks;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DetalhesLivroActivity extends BaseActivity {
	
	private TextView mTxtTituloLivro;
	private TextView mTxtAutorLivro;
	private TextView mTxtEditoraLivro;
	private TextView mTxtPrecoLivro;
	private TextView mTxtIsbaLivro;
	private Button mBtnAdicionarCarrinho;
	private Button mBtnComprar;
	

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
		
		
		TestListBooks livros = new TestListBooks();
		mTxtTituloLivro.setText(livros.listaLivro.get(0).getTitulo());
		mTxtAutorLivro.setText(livros.listaLivro.get(0).getAutor());
		mTxtEditoraLivro.setText(livros.listaLivro.get(0).getEditora());
		mTxtPrecoLivro.setText(String.valueOf(livros.listaLivro.get(0).getPreco()));
		mTxtIsbaLivro.setText(livros.listaLivro.get(0).getIsbn());
		
		mBtnAdicionarCarrinho.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
			}
		});
		
		mBtnComprar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
			}
		});
		
		
		getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_SHOW_HOME);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		return super.onOptionsItemSelected(item);
	}
}
