package com.example.xcsbooks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import control.TestListBooks;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class CarrinhoActivity extends BaseActivity {
	private Button mBtnComprar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_carrinho);
		
		mBtnComprar = (Button) findViewById(R.id.carrinho_btnComprar);
		ListView mLv = (ListView) findViewById(R.id.carrinho_listaItensView);
			
		//...
		TestListBooks livros = new TestListBooks();
		
		List list = new ArrayList();
		Map map = null;
		for(int i=0;i<livros.listaLivro.size();i++) {
			map = new HashMap();
			map.put("itemCarrinho_thumbLivro", R.drawable.book_icon);
			map.put("itemCarrinho_tituloLivro", livros.listaLivro.get(i).getTitulo().toString());
			map.put("itemCarrinho_autorLivro", livros.listaLivro.get(i).getAutor().toString());
			map.put("itemCarrinho_editoraLivro", livros.listaLivro.get(i).getEditora());
			map.put("itemCarrinho_quantidade", 1);
			map.put("itemCarrinho_precoLivro", livros.listaLivro.get(i).getPreco());
			list.add(map);
		}
		
		//Adapter
		SimpleAdapter adapter = new SimpleAdapter(this, (List <? extends Map<String, ?>>) list, 
			R.layout.item_carrinho, 
			new String[] {
				"itemCarrinho_thumbLivro",
				"itemCarrinho_tituloLivro",
				"itemCarrinho_autorLivro",
				"itemCarrinho_editoraLivro",
				"itemCarrinho_quantidade",
				"itemCarrinho_precoLivro"},
			new int[] {
				R.id.itemCarrinho_thumbLivro,
				R.id.itemCarrinho_txtTituloLivro,
				R.id.itemCarrinho_txtAutorLivro,
				R.id.itemCarrinho_txtEditoraLivro,
				R.id.itemCarrinho_txtQuantidadeLivro,
				R.id.itemCarrinho_txtPrecoLivro});
		
		
		
		mLv.setAdapter(adapter);
		
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
