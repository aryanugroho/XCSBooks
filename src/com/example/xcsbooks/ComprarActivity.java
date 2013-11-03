package com.example.xcsbooks;

import com.example.xcsbooks.control.LoginControl;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class ComprarActivity extends BaseActivity {
	private TextView tv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_comprar);
		
		tv = (TextView) findViewById(R.id.comprar_Logado);
		if(LoginControl.getClienteLogado() == null){
			Toast.makeText(this, "Logue para poder comprar", Toast.LENGTH_LONG).show();
			Intent intent = new Intent(ComprarActivity.this, LogarActivity.class);
			startActivity(intent);
		} else {
			tv.setText("Você está logado e pode comprar. :)");
		}
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
