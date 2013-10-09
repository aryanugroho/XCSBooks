package com.example.xcsbooks;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {
	public Integer[] thumbIds = 
			{R.drawable.search_database, R.drawable.user_accept,
			 R.drawable.shopping_cart,	 R.drawable.delete_home };
	
	public String[] descricao; 
	private Context mContext;

	public GridAdapter(Context c){
		mContext = c;
	}
	
	@Override
	public int getCount() {
		return thumbIds.length;
	}

	@Override
	public Object getItem(int position) {
		return thumbIds[position];
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View mView = convertView;
		
		if(convertView == null){
			LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			mView = inflater.inflate(R.layout.grid_item, null);
			
			ImageView imageView = (ImageView) mView.findViewById(R.id.grid_item_image);
			imageView.setImageResource(thumbIds[position]);
			//imageView.setLayoutParams(new GridView.LayoutParams(200,200));
			imageView.setScaleType(ImageView.ScaleType.CENTER);
			
			TextView textView = (TextView) mView.findViewById(R.id.grid_item_text);
			descricao = mContext.getResources().getStringArray(R.array.desricao_home);
			textView.setText(descricao[position]);
		}
		
		return mView;
	}

}
