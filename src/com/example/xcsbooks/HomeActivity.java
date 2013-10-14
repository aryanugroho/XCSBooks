package com.example.xcsbooks;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import control.LoginControl;

public class HomeActivity extends BaseActivity {
	public static final String KEY_BUSCA = "com.example.xcsbooks.KEY_BUSCA";
	public static HomeActivity instance;
	private Button mBtnBuscar;
	private EditText mEditBuscar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		instance = this;
		mBtnBuscar = (Button) findViewById(R.id.home_btnBuscar);
		mEditBuscar = (EditText)findViewById(R.id.home_txtBusca);

		mEditBuscar.setImeOptions(EditorInfo.IME_ACTION_SEARCH);

		mBtnBuscar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(HomeActivity.this, BuscarActivity.class);
				String termoBusca = mEditBuscar.getText().toString();
				intent.putExtra(KEY_BUSCA, termoBusca);
				startActivity(intent);
			}
		});
		
		FragmentManager fm = getFragmentManager();
		Fragment fragment = fm.findFragmentById(R.id.home_fragment);
		
		if(fragment == null) {
			FragmentTransaction ft = fm.beginTransaction();
			if(LoginControl.getClienteLogado() == null){
				Log.d("LOGGED", "Cliente n�o est� logado");
				ft.add(R.id.home_fragment, new Fragment_Home());
			} else {
				Log.d("LOGGED", "Cliente est� logado");
				ft.add(R.id.home_fragment, new Fragment_Home_Logado());
			}
			ft.commit();
		}
				
		getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_SHOW_HOME);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		return super.onOptionsItemSelected(item);
	}
	
	public static HomeActivity getInstance(){
		return instance;
	}
}
