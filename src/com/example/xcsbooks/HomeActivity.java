package com.example.xcsbooks;

import com.example.xcsbooks.control.LoginControl;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;

public class HomeActivity extends BaseActivity {
	public static HomeActivity instance;
	private Button mBtnBuscar;
	private EditText mEditBuscar;
	private Fragment frag;
	
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
	}
	
	@Override
	protected void onStop(){
		super.onStop();
	}
	
	@Override
	protected void onResume(){
		super.onResume();
		FragmentManager fm = getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		
		Fragment fragment = fm.findFragmentById(R.id.home_fragment);
		
		if(fragment == null) {
			if(LoginControl.getClienteLogado() == null){
				frag = new Fragment_Home();
				ft.add(R.id.home_fragment, frag);
			} else {
				frag = new Fragment_Home_Logado();
				ft.add(R.id.home_fragment, frag);
			}
			ft.commit();
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
	
	public static HomeActivity getInstance(){
		return instance;
	}
}
