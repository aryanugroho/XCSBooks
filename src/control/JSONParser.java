package control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.LogRecord;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class JSONParser {

	public static Map<String, Object> parseLogin(String JSONStr){
		Map<String, Object> map = new HashMap<String, Object>();
		
		try{
			JSONObject jobj = new JSONObject(JSONStr);
			JSONObject login = jobj.getJSONObject("login");
			map.put("session_id", login.getString("sessionID"));
			map.put("nome", login.getString("nome"));
			map.put("cpf", login.getString("cpf"));
			map.put("email", login.getString("email"));
			map.put("telefone1", login.getString("telefone1"));
			map.put("telefone2", login.getString("telefone2"));
			
			JSONObject e = login.getJSONObject("endereco");
				
			map.put("logradouro", e.getString("logradouro"));	
			map.put("numero", e.getInt("numero"));
			map.put("complemento", e.getString("complemento"));
			map.put("bairro", e.getString("bairro"));
			map.put("uf", e.getString("uf"));
			map.put("cep", e.getString("cep"));
			
		} catch (JSONException e) {
			Log.e("JSON", "Error parsing JSONString: " + JSONStr);
		}
		
		return map;
	}
	
	public List<Map<String, String>> parseBusca(String JSONStr){
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = new HashMap<String, String>();
		
		try{
			JSONObject jobj = new JSONObject(JSONStr);
			JSONArray livros = jobj.getJSONArray("livros");
			System.out.println(livros.get(0));
		} catch (JSONException e) {
			Log.e("JSON", "Error parsing JSONString: " + JSONStr);
		}
		
		return list;
	}
	
	public Map<String, String> parseCadastro(String JSONStr){
		Map<String, String> map = new HashMap<String, String>();
		
		return map;
	}
}
