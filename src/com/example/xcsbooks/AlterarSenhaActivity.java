package com.example.xcsbooks;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;

public class AlterarSenhaActivity extends Activity {
	private EditText prevSenhaEdit;
	private EditText newSenhaEdit;
	private Button submit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alterar_senha);
		
		prevSenhaEdit = (EditText) findViewById(R.id.prevSenha);
		newSenhaEdit = (EditText) findViewById(R.id.newSenha);
		submit = (Button) findViewById(R.id.submitNewSenha);
		
		String prevSenha = prevSenhaEdit.getText().toString();
		String newSenha = newSenhaEdit.getText().toString();
		
		//TODO enviar senha control
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.alterar_senha, menu);
		return true;
	}

}
