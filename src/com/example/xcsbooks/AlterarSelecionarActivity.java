package com.example.xcsbooks;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class AlterarSelecionarActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alterar_selecionar);
		
		//TODO completar a lista com 3 elementos, cada um � um bot�o para a tela de altera��o
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.alterar_selecionar, menu);
		return true;
	}

}
