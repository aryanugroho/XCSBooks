package com.example.xcsbooks;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class BuscarActivity extends BaseActivity {
	private String termo;
	private EditText mEditBusca;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_buscar);
	
		termo = getIntent().getStringExtra(BaseActivity.KEY_BUSCA);
		mEditBusca = (EditText) findViewById(R.id.buscar_caixa_busca);
		mEditBusca.setText(termo);
		mEditBusca.clearFocus();
		
		//...
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		return super.onOptionsItemSelected(item);
	}
}
