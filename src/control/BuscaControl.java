package control;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Livro;
import model.LivroNovo;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.os.AsyncTask;
import android.util.Log;

public class BuscaControl {
	public static String BUSCA_URI = "http://diskexplosivo.com/xcsbooks/search.php";
	
	public static List<LivroNovo> buscar(String termo){
		AsyncTask<URI, Integer, String> task;
		String resposta = null;
		
		List<NameValuePair> searchData = new ArrayList<NameValuePair>();
		searchData.add(new BasicNameValuePair("s", termo));
		
		try {
			//Faz um request para LOGIN_URI com os dados digitados
			task = new RequestTask(searchData, BUSCA_URI, RequestTask.REQUEST_GET).execute();
			//Obtém a resposta do back-end
			resposta = task.get();
		} catch (Exception e){
			Log.e("SEARCH_REQUEST", "Error on GET REQUEST to URL");
		}
		
		if(resposta != null){
		
			try{
				int test = Integer.parseInt(resposta);
				if(test < 0){
					Log.d("SEARCH_F", "Resposta: " + test);
					return new ArrayList();
				}
			} catch (NumberFormatException e){
				Log.e("PARSE_EX", "Error parsing resposta to Integer");
			}
			
			//Obtém resposta JSON parseada
			List <? extends Map<String, ?>> u = JSONParser.parseBusca(resposta);
		
			Map t = null;
			List<LivroNovo> list = new ArrayList<LivroNovo>();
			for(int i = 0; i < u.size(); i++){
				t = new HashMap();
				t = u.get(i);
				LivroNovo l = new LivroNovo(
						i, Integer.parseInt((String) t.get("quantidade")),
						Double.parseDouble((String) t.get("preco")),
						(String)t.get("isbn"),
						(String)t.get("titulo"),
						(String)t.get("autor"),
						(String)t.get("editora"));
				list.add(l);
				Log.d("LIVRO_I", "Nome: " + l.getTitulo());
			}
			
			//Lê a lista, e cria uma segunda lista, mas com os dados do livro em forma de model
			return list;
		}
		
		return new ArrayList();
	}
}