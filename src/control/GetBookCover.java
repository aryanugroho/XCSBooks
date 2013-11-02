package control;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;

public class GetBookCover {
	public static String BUSCA_URI = "http://diskexplosivo.com/xcsbooks/cover.php";
	
	public static Bitmap getCover(String isbn){
		AsyncTask<URI, Integer, String> task;
		String resposta = null;
		
		List<NameValuePair> searchData = new ArrayList<NameValuePair>();
		searchData.add(new BasicNameValuePair("i", isbn));
		
		try {
			//Faz um request para LOGIN_URI com os dados digitados
			task = new RequestTask(searchData, BUSCA_URI, RequestTask.REQUEST_GET).execute();
			//Obtém a resposta do back-end
			resposta = task.get();
		} catch (Exception e){
			Log.e("COVER_REQUEST", "Error on GET REQUEST to URL");
		}
		
		if(resposta != null){
		
			try{
				int test = Integer.parseInt(resposta);
				if(test < 0){
					Log.d("SEARCH_F", "Resposta: " + test);
					return null;
				}
			} catch (NumberFormatException e){
				Log.e("PARSE_EX", "Error parsing resposta to Integer");
			}
			
			//Obtem a resposta e transforma em um Bitmap
		}
		
		return null;
	}
}
