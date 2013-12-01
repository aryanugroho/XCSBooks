package com.example.xcsbooks.control;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

import com.example.xcsbooks.HomeActivity;
import com.example.xcsbooks.LogarActivity;
import com.example.xcsbooks.model.Cliente;
import com.example.xcsbooks.model.Endereco;

public class LoginControl {
	public static String LOGIN_URI = "http://diskexplosivo.com/xcsbooks/login_cliente.php";
	
	public static Cliente logar(String username, String password){
		AsyncTask<URI, Integer, String> task;
		String resposta = null;
		
		List<NameValuePair> loginData = new ArrayList<NameValuePair>();
		loginData.add(new BasicNameValuePair("username", username));
		loginData.add(new BasicNameValuePair("senha", password));
		
		try {
			//Faz um request para LOGIN_URI com os dados digitados
			task = new RequestTask(loginData, LOGIN_URI, RequestTask.REQUEST_POST).execute();
			//Obtém a resposta do back-end
			resposta = task.get();
		} catch (Exception e){
			Log.e("LOGIN_REQUEST", "Error on POST REQUEST to URL");
		}
		
		if(resposta != null){
			
			int test = JSONParser.parseResposta(resposta);
			if(test < 0)
				return null;
				
			//Obtém resposta JSON parseada
			Map<String, Object> u = JSONParser.parseLogin(resposta);
			//Cria um novo Usuário e salva a session
			Cliente cli = 
				new Cliente(username, password, 
						(String) u.get("nome"),
						(String) u.get("cpf"),
						(String) u.get("email"),
						(String) u.get("telefone1"),
						(String) u.get("telefone2"), 
						new Endereco(
									(String) u.get("logradouro"),
									(Integer)u.get("numero"),
									(String) u.get("complemento"),
									(String) u.get("bairro"),
									(String) u.get("cidade"),
									(String) u.get("uf"),
									(String) u.get("cep")) );
			
			// Salvar sessionId e informações do usuário logado na persistência
			SharedPreferences prefs = LogarActivity.getInstance().getSharedPreferences("LOGIN_CREDENTIALS", LogarActivity.MODE_PRIVATE);
			SharedPreferences.Editor editor = prefs.edit();
			
			editor.putString("session", (String) u.get("session_id"));
			editor.putString("username", username);
			editor.putString("nome", cli.getNome());
			editor.putString("cpf", cli.getCpf());
			editor.putString("email", cli.getEmail());
			editor.putString("telefone1", cli.getTelefone1());
			editor.putString("telefone2", cli.getTelefone2());
			editor.putString("logradouro", cli.getEndereco().getLogradouro());
			editor.putString("numero", String.valueOf(cli.getEndereco().getNumero()));
			editor.putString("complemento", cli.getEndereco().getComplemento());
			editor.putString("bairro", cli.getEndereco().getBairro());
			editor.putString("cidade", cli.getEndereco().getCidade());
			editor.putString("uf", cli.getEndereco().getUf());
			editor.putString("cep", cli.getEndereco().getCep());
			editor.commit();
			//TODO: Colocar endereço (serializar)
			
			return cli;
		}
		return null;
	}
	
	private static boolean isLogged(SharedPreferences prefs){
		String sessionId = prefs.getString("session", "-1");
		if(!sessionId.equals("-1")){
			return true;
		}
		return false;
	}
	
	public static Cliente getClienteLogado(){
		Cliente cli = null;
		SharedPreferences prefs = HomeActivity.getInstance().getSharedPreferences("LOGIN_CREDENTIALS", HomeActivity.MODE_PRIVATE);
		
		if(isLogged(prefs)){
			cli = new Cliente(prefs.getString("username", "NULL"),
							prefs.getString("senha", "NULL"), 
							prefs.getString("nome", "NULL"),
							prefs.getString("cpf", "NULL"),
							prefs.getString("email", "NULL"),
							prefs.getString("telefone1", "NULL"),
							prefs.getString("telefone2", "NULL"),
							null);
			//TODO: Obter Endereço
		}
		
		return cli;
	}
	
	public static void logout(){
		SharedPreferences prefs = HomeActivity.getInstance().getSharedPreferences("LOGIN_CREDENTIALS", HomeActivity.MODE_PRIVATE);
		SharedPreferences.Editor editor = prefs.edit();
		
		editor.remove("session").remove("username").remove("senha").remove("nome").remove("cpf")
		.remove("email").remove("telefone1").remove("telefone2").commit();
		//TODO: Remover endereço
	}
}
