package com.example.xcsbooks;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xcsbooks.control.JSONParser;
import com.examples.xcsbooks.model.LivroNovo;

//TODO: Corrigir bug de não mostrar corretamente a lista
public class CarrinhoListAdapter extends ExtendedSimpleAdapter {
	LayoutInflater inflater = null;
	Context context = null;
	List<? extends Map<String, ?>> data;
	
	public CarrinhoListAdapter(Context context,
			List<? extends Map<String, ?>> data, int resource, String[] from,
			int[] to) {
		super(context, (List<HashMap<String, Object>>) data, resource, from, to);
		inflater = LayoutInflater.from(context);
		this.context = context;
		this.data = data;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent)
	{
		final View view = super.getView(position, convertView, parent);
	    ViewHolder holder = (ViewHolder) view.getTag();
	    if(holder == null){
	    	holder = new ViewHolder();
	    	holder.titulo = (TextView) view.findViewById(R.id.itemCarrinho_txtTituloLivro);
	    	holder.autor = (TextView) view.findViewById(R.id.itemCarrinho_txtAutorLivro);
	    	holder.editora = (TextView) view.findViewById(R.id.itemCarrinho_txtEditoraLivro);
	    	holder.preco = (TextView) view.findViewById(R.id.itemCarrinho_txtPrecoLivro);
	    	holder.quant = (TextView) view.findViewById(R.id.itemCarrinho_txtQuantidadeLivro);
	    	holder.dec =(Button) view.findViewById(R.id.itemCarrinho_btnDecremento);
	    	holder.inc = (Button) view.findViewById(R.id.itemCarrinho_btnIncremento);
	    	holder.remove = (Button) view.findViewById(R.id.itemCarrinho_remover);
	    	holder.thumbnail = (ImageView) view.findViewById(R.id.itemCarrinho_thumbLivro);
	    	view.setTag(holder);
	    	final Context context = view.getContext();
	    	
	    	holder.dec.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
				}
			});
	    	
	    	holder.inc.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
				}
			});
	    	
	    	holder.remove.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					data.remove(position);
					// Efetivamente removendo o livro do carrinho
					SharedPreferences prefs = context.getSharedPreferences("CARRINHO", context.MODE_PRIVATE);
					String strlivros = prefs.getString("LIVROS", JSONParser.DEFAULT_LIVROS);
					// Obtem a lista de livros que está guardada como um JSON
					List<LivroNovo> livros = JSONParser.LivroFromJSON(strlivros);
					livros.remove(position);
					// Transforma a nova lista em um JSON
					String carrinho = JSONParser.LivroToJSON(livros);
					//Guarda o novo JSON
					SharedPreferences.Editor editor = prefs.edit();
					editor.clear().putString("LIVROS", carrinho).commit();
					//Notifica o usuario, atualiza a lista
					Toast.makeText(context, "Item removido", Toast.LENGTH_LONG).show();
					notifyDataSetChanged();
				}
			});
	    }
	    
	    return view;
		
	}
	
	static class ViewHolder {
		ImageView thumbnail;
		TextView titulo;
		TextView autor;
		TextView editora;
		TextView preco;
		TextView quant;
		Button inc;
		Button dec;
		Button remove;
	}
	
	public class YourWrapper
	{
	    private View base;
	    private Button increment;
	    private Button decrement;
	    private Button remove;
	    private ImageView iv;
	    
	    public YourWrapper(View base)
	    {
	        this.base = base;
	    }

	    public Button getIncrementButton()
	    {
	        if (increment == null)
	        {
	            increment = (Button) base.findViewById(R.id.itemCarrinho_btnIncremento);
	        }
	        return (increment);
	    }
	    
	    public Button getDecrementButton()
	    {
	        if (decrement == null)
	        {
	            decrement = (Button) base.findViewById(R.id.itemCarrinho_btnDecremento);
	        }
	        return (decrement);
	    }
	    
	    public Button getRemoveButton()
	    {
	        if (remove == null)
	        {
	        	remove = (Button) base.findViewById(R.id.itemCarrinho_remover);
	        }
	        return (remove);
	    }
	}
	
}
