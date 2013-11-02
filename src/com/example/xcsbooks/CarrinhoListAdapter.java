package com.example.xcsbooks;

import java.util.List;
import java.util.Map;

import model.LivroNovo;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import control.JSONParser;

//TODO: Corrigir bug de não mostrar corretamente a lista
public class CarrinhoListAdapter extends SimpleAdapter {
	LayoutInflater inflater = null;
	Context context = null;
	List<? extends Map<String, ?>> data;
	
	public CarrinhoListAdapter(Context context,
			List<? extends Map<String, ?>> data, int resource, String[] from,
			int[] to) {
		super(context, data, resource, from, to);
		inflater = LayoutInflater.from(context);
		this.context = context;
		this.data = data;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent)
	{
		super.getView(position, convertView, parent);
	    View row = convertView;
	    YourWrapper wrapper = null;

	    if (row == null)
	    {
	        row = inflater.inflate(R.layout.item_carrinho, parent, false);
	        wrapper = new YourWrapper (row);
	        row.setTag(wrapper);
	    }
	    else
	        wrapper = (YourWrapper) row.getTag();

	    wrapper.getIncrementButton().setOnClickListener(new OnClickListener()
	    {
	        @Override
	        public void onClick(View v)
	        {
	            Toast.makeText(context, "Incrementado", Toast.LENGTH_LONG).show();
	            //TODO: Efetivamente incrementar item
	        }
	    });
	    
	    wrapper.getDecrementButton().setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO: Efetivamente decrementar item 
				
			}
		});
	    
	    wrapper.getRemoveButton().setOnClickListener(new OnClickListener() {
			
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

	    return row;
	}
	
	public class YourWrapper
	{
	    private View base;
	    private Button increment;
	    private Button decrement;
	    private Button remove;

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
