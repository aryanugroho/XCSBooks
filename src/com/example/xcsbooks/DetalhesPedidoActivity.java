package com.example.xcsbooks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.xcsbooks.control.GetBookCover;
import com.example.xcsbooks.control.JSONParser;
import com.example.xcsbooks.model.Dinheiro;
import com.example.xcsbooks.model.LivroNovo;
import com.example.xcsbooks.model.Pedido;
import com.example.xcsbooks.model.Produto;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class DetalhesPedidoActivity extends BaseActivity {

	private Pedido pedido;
	private ListView mLv; 

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalhes_pedido);
				
		mLv = (ListView) findViewById(R.id.detalhePedido_listaItensView);
		View v = getLayoutInflater().inflate(R.layout.detalhe_pedido_header, null);
		TextView mTxtIdPedido = (TextView) findViewById(R.id.detalhePedido_txtId);
		TextView mTxtDatahoraPedido = (TextView) findViewById(R.id.detalhePedido_txtDatahora);
		TextView mTxtEstadPedido = (TextView) findViewById(R.id.detalhePedido_txtEstado);
		TextView mTxtTotalPedido = (TextView) findViewById(R.id.detalhePedido_txtTotal);
		mLv.addHeaderView(v);
		
		//Obtem o objeto pedido passado
		Intent i = getIntent();
		Resources r = getResources();
		
		pedido = (Pedido) i.getParcelableExtra(AcompanharPedidoActivity.KEY_PEDIDO);
		if(pedido.getId()!=0){
			mTxtIdPedido.setText(r.getString(R.string.id) + ": " +pedido.getId());
			mTxtDatahoraPedido.setText(r.getString(R.string.datahora)+": "+pedido.getDatahora());
			mTxtEstadPedido.setText(r.getString(R.string.status) + ": " + pedido.getEstado());
			mTxtTotalPedido.setText(r.getString(R.string.total) + ": " + pedido.getTotal().toString());
		}
		
		/*
		List searchList = new ArrayList();
		Map map = null;
		for(Produto p : pedido.getProdutos()) {
			map = new HashMap();
			map.put("itemLista_thumbLivro", GetBookCover.getCover(((LivroNovo)p).getIsbn()));
			map.put("itemLista_tituloLivro", ((LivroNovo)p).getTitulo());
			map.put("itemLista_autorLivro", ((LivroNovo)p).getAutor());
			searchList.add(map);
		}
		String[] t = {"itemLista_thumbLivro","itemLista_tituloLivro",
				"itemLista_autorLivro"};
		
		int[] item = {R.id.itemLista_thumbLivro,
				R.id.itemLista_tituloLivro, R.id.itemLista_autorLivro};
	
		//Adapter

		final ExtendedSimpleAdapter adapter = new ExtendedSimpleAdapter(this, (List<HashMap<String, Object>>) searchList, R.layout.item_lista, t , item);
		
		mLv.setAdapter(adapter);
		*/
		
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		return super.onOptionsItemSelected(item);
	}
}
