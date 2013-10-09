package com.example.xcsbooks;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class BuscarActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_buscar);
		
		TextView tv = new TextView(this);
		String termo = getIntent().getStringExtra(HomeActivity.KEY_BUSCA);
		tv.setText(termo);
		tv.setTextSize(40);
		
		setContentView(tv);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.buscar, menu);
		return true;
	}

}
