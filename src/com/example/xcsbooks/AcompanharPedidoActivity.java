package com.example.xcsbooks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.xcsbooks.control.BuscaControl;
import com.example.xcsbooks.control.LoginControl;
import com.example.xcsbooks.model.Pedido;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class AcompanharPedidoActivity extends BaseActivity {
	
	private List searchList;
	private List<Pedido> pedidos;
	public static final String KEY_PEDIDO = "com.example.xcsbooks.buscar.PEDIDO";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_acompanhar_pedido);
		
		ListView lv = (ListView) findViewById(R.id.acompanharPedido_listaPedidosView);
		pedidos = BuscaControl.buscarPedido(LoginControl.getClienteLogado().getUsername());
		
		searchList = new ArrayList();
		
		Map map = null;
		for(Pedido pedido : pedidos) {
			map = new HashMap();
			map.put("itemListaPedido_codigoPedido", pedido.getCodigo());
			map.put("itemListaPedido_dataPedido", pedido.getData());
			map.put("itemListaPedido_precoPedido", String.valueOf(pedido.getPreco()));
			searchList.add(map);
		}
		
		String[] t = {"itemListaPedido_codigoPedido","itemListaPedido_dataPedido","itemListaPedido_precoPedido"};
		
		int[] i = {R.id.itemListaPedido_codigoPedido,R.id.itemListaPedido_dataPedido, R.id.itemListaPedido_precoPedido};
		
		//Adapter
	
		final ExtendedSimpleAdapter adapter = new ExtendedSimpleAdapter(this, (List<HashMap<String, Object>>) searchList, R.layout.item_lista_pedido, t , i);
		
		lv.setAdapter(adapter);
	
		lv.setOnItemClickListener(new OnItemClickListener() {
		
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent = new Intent(AcompanharPedidoActivity.this, DetalhesPedidoActivity.class);
				intent.putExtra(KEY_PEDIDO, pedidos.get(position));
				startActivity(intent);
			}
		});

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
