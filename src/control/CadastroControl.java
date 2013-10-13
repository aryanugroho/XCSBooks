package control;

import java.net.URI;
import java.util.List;

import model.Cliente;
import model.Endereco;

import org.apache.http.NameValuePair;

import android.os.AsyncTask;
import android.util.Log;

public class CadastroControl {
	public static String CADASTRO_URI = "http://192.168.1.18/xcsbooks/register.php";
	
	public static Cliente cadastrar(List<NameValuePair> list) {
		AsyncTask<URI, Integer, String> task;
		String resposta = null;
	
		try {
			//Faz um request para LOGIN_URI com os dados digitados
			task = new RequestTask(list, CADASTRO_URI, RequestTask.REQUEST_POST).execute();
			//Obtém a resposta do back-end
			resposta = task.get();
		} catch (Exception e){
			Log.e("CADASTRO_REQUEST", "Error on POST REQUEST to URL");
		}
		
		if(resposta != null){
			
			try{
				int test = Integer.parseInt(resposta);
				if(test < 0)
					return null;
			} catch (NumberFormatException e){
				Log.e("PARSE_EX", "Error parsing resposta to Integer");
			}
			
			//Cliente(String * 7, Endereco(S	tring * 7))
			Cliente cli = 
				new Cliente(
					list.get(0).getValue(),
					list.get(1).getValue(),
					list.get(2).getValue(),
					list.get(3).getValue(),
					list.get(4).getValue(),
					list.get(5).getValue(),
					list.get(6).getValue(),
					new Endereco(
							list.get(7).getValue(),
							Integer.parseInt(list.get(8).getValue()),
							list.get(9).getValue(),
							list.get(10).getValue(),
							list.get(11).getValue(),
							list.get(12).getValue(),
							list.get(13).getValue()));
			return cli;
			
		}			
		return null;
	}
}
