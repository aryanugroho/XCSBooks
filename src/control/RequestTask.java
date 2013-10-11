package control;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.os.AsyncTask;

public class RequestTask extends AsyncTask<URI, Integer, String>{
	private List<NameValuePair> args;
	private String urlArg;
	private int method;
	
	public final static int REQUEST_POST = 1;
	public final static int REQUEST_GET = 2;
	
	public RequestTask(List<NameValuePair> mArgs, String url, int mMethod) {
		args = mArgs;
		urlArg = url;
		method = mMethod;
	}
	
    @Override
    protected String doInBackground(URI... uri) {
        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse response;
        String responseString = null;
        
 
        try {
        	if(method == REQUEST_GET){
        		urlArg += "?";
        		for(int i = 0; i < args.size(); i++){
        			urlArg += args.get(i).getName() + "=" + args.get(i).getValue() + "&";
        		}
        		urlArg =  urlArg.substring(0, urlArg.length()-1);
        		
        		HttpGet get = new HttpGet(urlArg);
        		response = httpclient.execute(get);
        	} else {
        		HttpPost post = new HttpPost(uri[0]);
            	post.setEntity(new UrlEncodedFormEntity(args));
                response = httpclient.execute(post);
        	}
        	
            
            StatusLine statusLine = response.getStatusLine();
            
            if(statusLine.getStatusCode() == HttpStatus.SC_OK){
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                response.getEntity().writeTo(out);
                out.close();
                responseString = out.toString();
            } else {
                //Closes the connection.
                response.getEntity().getContent().close();
                throw new IOException(statusLine.getReasonPhrase());
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseString;
    }  
}