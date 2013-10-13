package control;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.Cliente;
import model.Endereco;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.example.xcsbooks.LogarActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

public class LoginControl {
	public static String LOGIN_URI = "http://192.168.1.18/xcsbooks/login_cliente.php";
	
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
			
			try{
				int test = Integer.parseInt(resposta);
				if(test < 0){
					Log.d("LOGIN_F", "Resposta: " + test);
					return null;
				}
			} catch (NumberFormatException e){
				Log.e("PARSE_EX", "Error parsing resposta to Integer");
			}
			
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
									(Integer) u.get("numero"),
									(String) u.get("complemento"),
									(String) u.get("bairro"),
									(String) u.get("cidade"),
									(String) u.get("uf"),
									(String) u.get("cep")) );
			
			// Salvar sessionId e informações do usuário logado na persistência
			SharedPreferences prefs = LogarActivity.getInstance().getPreferences(LogarActivity.MODE_PRIVATE);
			SharedPreferences.Editor editor = prefs.edit();
			
			editor.putString("session", (String) u.get("sessionId")); 
			editor.putString("nome", cli.getNome());
			editor.putString("cpf", cli.getCpf());
			editor.putString("email", cli.getEmail());
			editor.putString("telefone1", cli.getTelefone1());
			editor.putString("telefone2", cli.getTelefone2());
			editor.commit();
			
			return cli;
		}
		
		return null;
	}
}
