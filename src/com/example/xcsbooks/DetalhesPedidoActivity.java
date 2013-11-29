package com.example.xcsbooks;

import com.example.xcsbooks.model.Dinheiro;
import com.example.xcsbooks.model.Pedido;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DetalhesPedidoActivity extends BaseActivity {

	private TextView mTxtCodigoPedido;
	private TextView mTxtDataPedido;
	private TextView mTxtPrecoPedido;
	private TextView mTxtStatusPedido;
	private Pedido pedido;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalhes_pedido);
		
		mTxtCodigoPedido = (TextView) findViewById(R.id.detalhePedido_txtCodigo);
		mTxtDataPedido = (TextView) findViewById(R.id.detalhePedido_txtData);
		mTxtPrecoPedido = (TextView) findViewById(R.id.detalhePedido_txtPreco);
		mTxtStatusPedido = (TextView) findViewById(R.id.detalhePedido_txtStatus);
		
		//Obtem o objeto pedido passado
		Intent i = getIntent();
		Resources r = getResources();
		
		pedido = (Pedido) i.getParcelableExtra(AcompanharPedidoActivity.KEY_PEDIDO);
		
		mTxtCodigoPedido.setText(r.getString(R.string.codigo) + ": " +pedido.getCodigo());
		mTxtDataPedido.setText(r.getString(R.string.data)+": "+pedido.getData());
		mTxtPrecoPedido.setText(r.getString(R.string.preco) + ": " + new Dinheiro(pedido.getPreco()).toString());
		mTxtStatusPedido.setText(r.getString(R.string.status) + ": " + pedido.getStatus());
		
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
