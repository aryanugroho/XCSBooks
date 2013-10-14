package com.example.xcsbooks;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter{

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		final View mView = arg1;
		
		if(arg1==null){
			Button btnIncremento = (Button) mView.findViewById(R.id.itemCarrinho_btnIncremento);
			btnIncremento.setClickable(true);
			btnIncremento.setFocusable(true);
			btnIncremento.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					TextView qtd = (TextView) mView.findViewById(R.id.itemCarrinho_txtQuantidadeLivro);
					qtd.setText(String.valueOf(1+Integer.valueOf(qtd.getText().toString())));
				}
			});
			
			Button btnDecremento = (Button) mView.findViewById(R.id.itemCarrinho_btnDecremento);
			btnDecremento.setClickable(true);
			btnDecremento.setFocusable(true);
			btnDecremento.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					TextView qtd = (TextView) mView.findViewById(R.id.itemCarrinho_txtQuantidadeLivro);
					if(Integer.valueOf(qtd.getText().toString())>1){
						qtd.setText(String.valueOf(1+Integer.valueOf(qtd.getText().toString())));
					}
				}
			});
			
		}
		
		return mView;
	}
	
}
