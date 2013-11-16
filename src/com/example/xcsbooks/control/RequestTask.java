package com.example.xcsbooks.control;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import java.util.Arrays;
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
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;
import android.util.Log;

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
        		if(!urlArg.endsWith("?"));
        			urlArg += "?";
        			
        		String paramStr = URLEncodedUtils.format(args, "utf-8");
        		urlArg += paramStr;
        		
        		Log.d("URL_GET", "URL: " + urlArg);
        		HttpGet get = new HttpGet(urlArg);
        		response = httpclient.execute(get);
        	} else {
        		HttpPost post = new HttpPost(urlArg);
        		System.out.println(urlArg);
            	post.setEntity(new UrlEncodedFormEntity(args));
                response = httpclient.execute(post);
        	}
        	
            
            StatusLine statusLine = response.getStatusLine();
            
            if(statusLine.getStatusCode() == HttpStatus.SC_OK){
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                response.getEntity().writeTo(out);
                responseString = out.toString();
                out.close();
                
                //byte[] b = out.toByteArray();
                //out = new ByteArrayOutputStream();
                //out.write(Arrays.copyOfRange(b, 3, b.length));
                
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