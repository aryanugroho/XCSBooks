package com.example.xcsbooks;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public class BaseActivity extends Activity {
	public static final String KEY_BUSCA = "com.example.xcsbooks.KEY_BUSCA";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM, ActionBar.DISPLAY_SHOW_HOME);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		Intent intent = null;
		switch (item.getItemId()) {
		case R.id.action_carrinho:
			intent = new Intent(this, CarrinhoActivity.class);
			startActivity(intent);
			break;
		case R.id.action_home:
			intent = new Intent(this, HomeActivity.class);
			startActivity(intent);
			break;
		case R.id.action_logar:
			intent = new Intent(this, LogarActivity.class);
			startActivity(intent);
			break;
		case R.id.action_busca:
			intent = new Intent(this, BuscarActivity.class);
			startActivity(intent);
		default:
			//Adicionar erro
			return false;
		}
		return true;
	}


}
