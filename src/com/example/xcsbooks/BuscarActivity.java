package com.example.xcsbooks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import control.TestListBooks;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class BuscarActivity extends BaseActivity {
	private String termo;
	private EditText mEditBusca;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_buscar);
	
		termo = getIntent().getStringExtra(BaseActivity.KEY_BUSCA);
		mEditBusca = (EditText) findViewById(R.id.busca_txtBusca);
		mEditBusca.setText(termo);
		mEditBusca.clearFocus();
		
		//...
		TestListBooks livros = new TestListBooks();
		ListView lv = (ListView) findViewById(R.id.busca_listaResultadosView);
		
		List list = new ArrayList();
		Map map = null;
		for(int i=0;i<livros.listaLivro.size();i++) {
			map = new HashMap();
			map.put("itemLista_thumbLivro", R.drawable.book_icon);
			map.put("itemLista_tituloLivro", livros.listaLivro.get(i).getTitulo().toString());
			map.put("itemLista_autorLivro", livros.listaLivro.get(i).getAutor().toString());
			map.put("itemLista_precoLivro", String.valueOf(livros.listaLivro.get(i).getPreco()));
			list.add(map);
		}
		
		//Adapter
		SimpleAdapter adapter = new SimpleAdapter(this, (List <? extends Map<String, ?>>) list, 
				R.layout.item_lista, new String[] {"itemLista_thumbLivro","itemLista_tituloLivro",
				"itemLista_autorLivro", "itemLista_precoLivro"}, new int[] {R.id.itemLista_thumbLivro,
				R.id.itemLista_tituloLivro, R.id.itemLista_autorLivro, R.id.itemLista_precoLivro});
		
		lv.setAdapter(adapter);
		
		//getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_SHOW_HOME);
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
