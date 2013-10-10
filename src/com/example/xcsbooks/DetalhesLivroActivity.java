package com.example.xcsbooks;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class DetalhesLivroActivity extends Activity {

	public static final String KEY_BUSCA = "com.example.xcsbooks.KEY_BUSCA";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalhes_livro);
		
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
		Intent intent = null;
		switch (item.getItemId()) {
		case R.id.action_carrinho:
			intent = new Intent(this, CarrinhoActivity.class);
			startActivity(intent);
			finish();
			break;
		case R.id.action_home:
			intent = new Intent(this, HomeActivity.class);
			startActivity(intent);
			finish();
			break;
		case R.id.action_logar:
			intent = new Intent(this, LogarActivity.class);
			startActivity(intent);
			finish();
			break;
		case R.id.action_sair:
			finish();
		case R.id.action_busca:
			LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
			EditText busca = new EditText(this);
			busca.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
			busca.setTextColor(Color.WHITE);
			busca.setInputType(InputType.TYPE_CLASS_TEXT);
			
			getActionBar().setCustomView(busca, lp);
			busca.requestFocus();
			
			InputMethodManager imm = (InputMethodManager)
					getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.showSoftInput(busca, InputMethodManager.SHOW_IMPLICIT);
			
			busca.setOnEditorActionListener(new OnEditorActionListener() {
				
				@Override
				public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
					String termo = v.getText().toString();
					Intent intent = new Intent(DetalhesLivroActivity.this, BuscarActivity.class);
					intent.putExtra(KEY_BUSCA, termo);
					startActivity(intent);
					finish();
					return true;
				}
			});
			
		default:
			//Adicionar erro
			return false;
		}
		return true;
	}
}
