package com.example.xcsbooks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.xcsbooks.control.GetBookCover;
import com.example.xcsbooks.model.Livro;
import com.example.xcsbooks.model.LivroNovo;
import com.example.xcsbooks.model.Pedido;
import com.example.xcsbooks.model.Produto;

public class DetalhesPedidoActivity extends BaseActivity {

	private Pedido pedido;
	private ListView mLv; 

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalhes_pedido);
				
		mLv = (ListView) findViewById(R.id.detalhePedido_listaItensView);
		View v = getLayoutInflater().inflate(R.layout.detalhe_pedido_header, null);
		TextView mTxtIdPedido = (TextView) v.findViewById(R.id.detalhePedido_txtId);
		TextView mTxtDatahoraPedido = (TextView) v.findViewById(R.id.detalhePedido_txtDatahora);
		TextView mTxtEstadPedido = (TextView) v.findViewById(R.id.detalhePedido_txtEstado);
		TextView mTxtTotalPedido = (TextView) v.findViewById(R.id.detalhePedido_txtTotal);
		mLv.addHeaderView(v);
		
		//Obtem o objeto pedido passado
		Intent i = getIntent();
		Resources r = getResources();
		
		pedido = (Pedido) i.getParcelableExtra(AcompanharPedidoActivity.KEY_PEDIDO);

		if(pedido.getId()!= 0){
			mTxtIdPedido.setText(r.getString(R.string.pedidoid) + ": " + pedido.getId());
			mTxtDatahoraPedido.setText(r.getString(R.string.data)+ ": " + pedido.getDatahora().substring(0, 10)+ " "+
					r.getString(R.string.hora)+": "+pedido.getDatahora().substring(11,19));
			mTxtEstadPedido.setText(r.getString(R.string.status) + ": " + pedido.getEstado());
			mTxtTotalPedido.setText(r.getString(R.string.total) + ": " + pedido.getTotal().toString());
		}
		
		List searchList = new ArrayList();
		Map map = null;
		//TODO: Adicionar quantidade em cada um dos itens da lista!
		for(Produto p : pedido.getProdutos()) {
			map = new HashMap();
			map.put("itemProdutoListaPedido_thumbLivro", GetBookCover.getCover(((Livro)p).getIsbn()));
			map.put("itemProdutoListaPedido_tituloLivro", getResources().getString(R.string.titulo) +": "+((Livro)p).getTitulo());
			map.put("itemProdutoListaPedido_autorLivro", ((Livro)p).getAutor());
			map.put("itemProdutoListaPedido_precoLivro", getResources().getString(R.string.preco)+": "+((Livro)p).getPreco());
			map.put("itemProdutoListaPedido_quantidadeProduto", getResources().getString(R.string.quantidade)+": "+((Livro)p).getQuantidade());
			searchList.add(map);
		}
		String[] t = {"itemProdutoListaPedido_thumbLivro","itemProdutoListaPedido_tituloLivro","itemProdutoListaPedido_autorLivro",
				"itemProdutoListaPedido_precoLivro", "itemProdutoListaPedido_quantidadeProduto"};
		
		int[] item = {R.id.itemProdutoListaPedido_thumbLivro,R.id.itemProdutoListaPedido_tituloLivro, R.id.itemProdutoListaPedido_autorLivro,
				R.id.itemProdutoListaPedido_precoLivro, R.id.itemProdutoListaPedido_quantidadeProduto};
	
		//Adapter
		final ExtendedSimpleAdapter adapter = new ExtendedSimpleAdapter(this, (List<HashMap<String, Object>>) searchList, R.layout.item_produto_lista_pedido, t , item);
		
		mLv.setAdapter(adapter);
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
