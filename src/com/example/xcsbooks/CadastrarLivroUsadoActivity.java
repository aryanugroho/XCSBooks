package com.example.xcsbooks;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.example.xcsbooks.control.CadastrarLivroUsadaControl;
import com.example.xcsbooks.model.LivroUsado;

import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastrarLivroUsadoActivity extends BaseActivity {

	private Button mBtnCadastrar;
	private EditText mEditIsbn;
	private EditText mEditTitulo;
	private EditText mEditAutor;
	private EditText mEditEditora;
	private EditText mPreco;
	
	private LivroUsado livrousado;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cadastrar_livro_usado);
		
		mBtnCadastrar = (Button) findViewById(R.id.cadastrarLivroUsado_btnCadastrar);
		mEditIsbn = (EditText) findViewById(R.id.cadastrarLivroUsado_txtIsbn);
		mEditTitulo = (EditText) findViewById(R.id.cadastrarLivroUsado_txtTitulo);
		mEditAutor = (EditText) findViewById(R.id.cadastrarLivroUsado_txtAutor);
		mEditEditora = (EditText) findViewById(R.id.cadastrarLivroUsado_txtEditora);
		mPreco = (EditText) findViewById(R.id.cadastrarLivroUsado_txtPreco);
		
		
		mBtnCadastrar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Envia dados para o controller! 
				Intent intent = getIntent();
				List<NameValuePair> list = new ArrayList<NameValuePair>();

				list.add(new BasicNameValuePair("isbn", mEditIsbn.getText().toString()));
				list.add(new BasicNameValuePair("titulo", mEditTitulo.getText().toString()));
				list.add(new BasicNameValuePair("autor", mEditAutor.getText().toString()));
				list.add(new BasicNameValuePair("editora", mEditEditora.getText().toString()));
				list.add(new BasicNameValuePair("preco", mPreco.getText().toString()));

				
				
				livrousado = CadastrarLivroUsadaControl.cadastrar(list);
				
				if(livrousado != null){
					Toast.makeText(getApplicationContext(), "Cadastro realizado com sucesso", Toast.LENGTH_LONG).show();
					intent 	= new Intent(CadastrarLivroUsadoActivity.this, HomeActivity.class);
					startActivity(intent);
				} else {
					Toast.makeText(getApplicationContext(), "Erro no cadastro", Toast.LENGTH_LONG).show();
				}

			}
		});
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

}
