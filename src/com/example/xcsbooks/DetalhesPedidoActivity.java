package com.example.xcsbooks;

import com.example.xcsbooks.model.Dinheiro;
import com.example.xcsbooks.model.Pedido;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class DetalhesPedidoActivity extends BaseActivity {

	private TextView mTxtIdPedido;
	private TextView mTxtDatahoraPedido;
	private TextView mTxtTotalPedido;
	private TextView mTxtEstadPedido;
	private Pedido pedido;
	private ListView mLv; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalhes_pedido);
		
		
		
		
		
		mLv = (ListView) findViewById(R.id.detalhePedido_listaItensView);
		View v = getLayoutInflater().inflate(R.layout.detalhe_pedido_header, null);
		mTxtIdPedido = (TextView) findViewById(R.id.detalhePedido_txtId);
		mTxtDatahoraPedido = (TextView) findViewById(R.id.detalhePedido_txtDatahora);
		mTxtEstadPedido = (TextView) findViewById(R.id.detalhePedido_txtEstado);
		mTxtTotalPedido = (TextView) findViewById(R.id.detalhePedido_txtTotal);
		mLv.addHeaderView(v);
		
		//Obtem o objeto pedido passado
		Intent i = getIntent();
		Resources r = getResources();
		
		pedido = (Pedido) i.getParcelableExtra(AcompanharPedidoActivity.KEY_PEDIDO);
		
		mTxtIdPedido.setText(r.getString(R.string.id) + ": " +pedido.getId());
		mTxtDatahoraPedido.setText(r.getString(R.string.datahora)+": "+pedido.getDatahora());
		mTxtEstadPedido.setText(r.getString(R.string.status) + ": " + pedido.getEstado());
		mTxtTotalPedido.setText(r.getString(R.string.total) + ": " + pedido.getTotal().toString());
		
		
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
