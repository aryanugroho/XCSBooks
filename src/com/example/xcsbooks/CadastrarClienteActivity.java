package com.example.xcsbooks;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class CadastrarClienteActivity extends BaseActivity {
	private Button mBtnContinue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cadastrar_cliente);
		
		mBtnContinue = (Button) findViewById(R.id.cadastrarCliente_btnContinue);
		
		mBtnContinue.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if( ((EditText) findViewById(R.id.cadastrarCliente_txtPassword)).getText().toString().equals(((EditText) findViewById(R.id.cadastrarCliente_txtValidePassword)).getText().toString()) ){
					Intent intent = new Intent(CadastrarClienteActivity.this, CadastrarEnderecoActivity.class);
					startActivity(intent);
				}
			}
		});
		
		
		getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_SHOW_HOME);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		return super.onOptionsItemSelected(item);
	}
	
}
