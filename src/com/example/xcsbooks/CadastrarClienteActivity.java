package com.example.xcsbooks;

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
	private EditText mEdtNome;
	private EditText mEdtCPF;
	private EditText mEdtEmail;
	private EditText mEditTel1;
	private EditText mEditTel2;
	private EditText mEdtUsername;
	private EditText mEdtPwd;
	private EditText mEdtPwdAgain;
	
	public static final String KEY_NOME = "com.example.xcsbooks.CADASTRAR_NOME";
	public static final String KEY_CPF = "com.example.xcsbooks.CADASTRAR_CPF";
	public static final String KEY_EMAIL = "com.example.xcsbooks.CADASTRAR_EMAIL";
	public static final String KEY_TEL1 = "com.example.xcsbooks.CADASTRAR_TEL1";
	public static final String KEY_TEL2 = "com.example.xcsbooks.CADASTRAR_TEL2";
	public static final String KEY_UNAME = "com.example.xcsbooks.CADASTRAR_UNAME";
	public static final String KEY_PWD = "com.example.xcsbooks.CADASTRAR_PWD";
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cadastrar_cliente);
		
		mBtnContinue = (Button) findViewById(R.id.cadastrarCliente_btnContinue);
		mEdtNome = (EditText) findViewById(R.id.cadastrarCliente_txtName);
		mEdtCPF = (EditText) findViewById(R.id.cadastrarCliente_txtCpf);
		mEdtEmail = (EditText) findViewById(R.id.cadastrarCliente_txtEmail);
		mEditTel1 = (EditText) findViewById(R.id.cadastrarCliente_txtTel1);
		mEditTel2 = (EditText) findViewById(R.id.cadastrarCliente_txtTel2);
		mEdtUsername = (EditText) findViewById(R.id.cadastrarCliente_txtUsername);
		mEdtPwd = (EditText) findViewById(R.id.cadastrarCliente_txtPassword);
		mEdtPwdAgain = (EditText) findViewById(R.id.cadastrarCliente_txtValidePassword);
		
		mBtnContinue.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String pwd = mEdtPwd.getText().toString();
				String pwd2 = mEdtPwdAgain.getText().toString();
				if(pwd.equals(pwd2)){
					Intent intent = new Intent(CadastrarClienteActivity.this, CadastrarEnderecoActivity.class);
					intent.putExtra(KEY_NOME, mEdtNome.getText().toString());
					intent.putExtra(KEY_CPF, mEdtCPF.getText().toString());
					intent.putExtra(KEY_EMAIL, mEdtEmail.getText().toString());
					intent.putExtra(KEY_TEL1, mEditTel1.getText().toString());
					intent.putExtra(KEY_TEL2, mEditTel2.getText().toString());
					intent.putExtra(KEY_UNAME, mEdtUsername.getText().toString());
					intent.putExtra(KEY_PWD, mEdtPwd.getText().toString());
					startActivity(intent);
				} else {
					//Error Dialog
				}
			}
		});
		
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
