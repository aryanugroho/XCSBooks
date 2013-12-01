package com.example.xcsbooks;

import com.example.xcsbooks.control.LoginControl;
import com.example.xcsbooks.model.Cliente;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class CadastrarClienteActivity extends BaseActivity {
	private Cliente cliente;
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
		cliente = LoginControl.getClienteLogado();
		
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
		
		if(cliente != null){ //Loggado - Alterar cadastro
			setTitle("Alterar Cadastro");
			mEdtCPF.setEnabled(false);
			mEdtUsername.setEnabled(false);
			
			mEdtPwd.setVisibility(View.GONE);
			mEdtPwdAgain.setVisibility(View.GONE);
			
			mEdtNome.setText(cliente.getNome());
			mEdtCPF.setText(cliente.getCpf());
			mEdtEmail.setText(cliente.getEmail());
			mEditTel1.setText(cliente.getTelefone1());
			mEditTel2.setText(cliente.getTelefone2());
			mEdtUsername.setText(cliente.getUsername());
		}
		
		mBtnContinue.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				boolean teste = true;
				
				if (cliente == null){
					String pwd = mEdtPwd.getText().toString();
					String pwd2 = mEdtPwdAgain.getText().toString();
					teste = pwd.equals(pwd2);
				}
				if(teste){
					Intent intent = new Intent(CadastrarClienteActivity.this, CadastrarEnderecoActivity.class);
					intent.putExtra(KEY_NOME, mEdtNome.getText().toString());
					intent.putExtra(KEY_EMAIL, mEdtEmail.getText().toString());
					intent.putExtra(KEY_TEL1, mEditTel1.getText().toString());
					intent.putExtra(KEY_TEL2, mEditTel2.getText().toString());
					intent.putExtra(KEY_CPF, mEdtCPF.getText().toString());
					intent.putExtra(KEY_UNAME, mEdtUsername.getText().toString());
					if (cliente == null){
						intent.putExtra(KEY_PWD, mEdtPwd.getText().toString());
					}
					startActivity(intent);
				} else {
					AlertDialog.Builder builder = new AlertDialog.Builder(CadastrarClienteActivity.this, android.R.style.Theme_DeviceDefault_Dialog_MinWidth);
					builder.setMessage("Senha não confere").setTitle("Senha").setCancelable(false).setIcon(android.R.drawable.stat_sys_warning)
											.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener(){
													@Override
												public void onClick(
														DialogInterface dialog,
														int which) {
													dialog.dismiss();
												}
												
											});
					AlertDialog dialog = builder.create();
					dialog.show();
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
