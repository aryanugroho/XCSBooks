package com.example.xcsbooks;

import android.app.ActionBar;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class HomeActivity extends Activity {
	private GridView mGridView;
	public static final String KEY_BUSCA = "com.example.xcsbooks.KEY_BUSCA";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mGridView = (GridView) findViewById(R.id.gridHomeView);
		mGridView.setAdapter(new GridAdapter(this));
		
		mGridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				//Abrir activities
				Intent intent = null;
				switch (position) {
				case 0:
					intent = new Intent(getApplicationContext(), BuscarActivity.class);
					startActivity(intent);
					break;
				case 1:
					intent = new Intent(getApplicationContext(), LogarActivity.class);
					startActivity(intent);
					break;
				case 2:
					intent = new Intent(getApplicationContext(), CarrinhoActivity.class);
					startActivity(intent);
					break;
				case 3:
					//Sair
					finish();
					break;
				default:
					break;
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
					Intent intent = new Intent(HomeActivity.this, BuscarActivity.class);
					intent.putExtra(KEY_BUSCA, termo);
					startActivity(intent);
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
