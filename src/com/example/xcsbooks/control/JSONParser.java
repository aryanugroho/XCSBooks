package com.example.xcsbooks.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.examples.xcsbooks.model.LivroNovo;

import android.util.Log;

public class JSONParser {
	public static final String DEFAULT_LIVROS = "{ login: [] }";

	public static Map<String, Object> parseLogin(String JSONStr){
		Map<String, Object> map = new HashMap<String, Object>();
		Log.d("JSON_LOGIN", JSONStr);
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
	
	public static List<Map<String, String>> parseBusca(String JSONStr){
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = null;
		
		try{
			JSONObject jobj = new JSONObject(JSONStr);
			JSONArray livros = jobj.getJSONArray("livros");

			for(int i = 0; i < livros.length(); i++){
				map = new HashMap<String, String>();
				JSONObject t = livros.getJSONObject(i);
				map.put("codigo", t.getString("codigo"));
				map.put("isbn", t.getString("isbn"));
				map.put("titulo", t.getString("titulo"));
				map.put("autor", t.getString("autor"));
				map.put("editora", t.getString("editora"));
				map.put("quantidade", t.getString("quantidade"));
				map.put("preco", t.getString("preco"));
				list.add(map);
			}
			
		} catch (JSONException e) {
			Log.e("JSON", "Error parsing JSONString: " + JSONStr);
		}
		
		return list;
	}
	
	public static String LivroToJSON(List<LivroNovo> list){
		String json = "{ \"livros\": [";
		
		for(int i = 0; i < list.size(); i++){
			json += "{";
				LivroNovo ln = list.get(i);
				json += "\"codigo\":\"" + ln.getCodigo() + "\",";
				json += "\"isbn\":\"" + ln.getIsbn() + "\",";
				json += "\"titulo\":\"" + ln.getTitulo() + "\",";
				json += "\"autor\":\"" + ln.getAutor() + "\",";
				json += "\"editora\":\"" + ln.getEditora() + "\",";
				json += "\"quantidade\":\"" + ln.getQuantidade() + "\",";
				json += "\"preco\":\"" + ln.getPreco() + "\"";
				
				if(i < list.size() - 1)
					json += "},";
				else
					json += "}";			
		}

		json += "]}";
		return json;
	}
	
	public static List<LivroNovo> LivroFromJSON(String json){
		List<LivroNovo> list = new ArrayList<LivroNovo>();
		
		try{
			JSONObject jobj = new JSONObject(json);
			JSONArray livros = jobj.getJSONArray("livros");
			LivroNovo ln;
			for(int i = 0; i < livros.length(); i++){
				JSONObject t = livros.getJSONObject(i);
				ln = new LivroNovo(
						Integer.parseInt(t.getString("codigo")),
						Integer.parseInt(t.getString("quantidade")),
						Double.parseDouble(t.getString("preco")),
						t.getString("isbn"),
						t.getString("titulo"),
						t.getString("autor"),
						t.getString("editora"));
				
				list.add(ln);
			}
			
		} catch (JSONException e) {
			Log.e("JSON", "Error parsing JSONString: " + json);
		}

		return list;
	}
}