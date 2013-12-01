package com.example.xcsbooks.control;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

public class RequestTask extends AsyncTask<URI, Integer, String>{
	private List<NameValuePair> args;
	private String urlArg;
	private int method;
	private SharedPreferences prefs;
	String ckName, ckValue;
	public final static int REQUEST_POST = 1;
	public final static int REQUEST_GET = 2;
	public final static String DOMAIN = "diskexplosivo.com";
	
	public RequestTask(List<NameValuePair> mArgs, String url, int mMethod) {
		args = mArgs;
		urlArg = url;
		method = mMethod;
		
	}
	
    @Override
    protected String doInBackground(URI... uri) {
        AbstractHttpClient httpclient = new DefaultHttpClient();
        HttpContext localContext = new BasicHttpContext();
        CookieStore ckStore = new BasicCookieStore();
        
        prefs = MyApplication.getInstance().getSharedPreferences("COOKIES", MyApplication.getInstance().MODE_PRIVATE);
		String ckName = prefs.getString("CK_NAME", "Test");
		String ckValue = prefs.getString(ckName, "Test");
		String ckPath = prefs.getString("CK_PATH", "/");
		String ckDomain = prefs.getString("CK_DOMAIN", DOMAIN);
		//@SuppressWarnings("deprecation")
		//Date ckDate = new Date(prefs.getString("CK_DATE", "2013-11-23"));
		Log.d("COOKIE_CONSTR", ckName + ckValue);
		
        BasicClientCookie cookie = new BasicClientCookie(ckName, ckValue);
        cookie.setDomain(ckDomain);
        cookie.setPath(ckPath);
        //cookie.setExpiryDate(ckDate);
        
        ckStore.addCookie(cookie);
        localContext.setAttribute(ClientContext.COOKIE_STORE, ckStore);
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
        		response = httpclient.execute(get, localContext);
        	} else {
        		HttpPost post = new HttpPost(urlArg);
        		System.out.println(urlArg);
            	post.setEntity(new UrlEncodedFormEntity(args));
                response = httpclient.execute(post, localContext);
        	}
        	
            
            StatusLine statusLine = response.getStatusLine();
            
            if(statusLine.getStatusCode() == HttpStatus.SC_OK){
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                response.getEntity().writeTo(out);
                responseString = out.toString();
                out.close();
                
                responseString = out.toString();

                CookieStore cookieStore = httpclient.getCookieStore();
                List<Cookie> cookies = cookieStore.getCookies();
                //Save cookie to sharedpref
                for(Cookie c : cookies){
                	Log.d("COOKIES", c.getName() + c.getValue());
                	SharedPreferences prefs = MyApplication.getInstance().getSharedPreferences("COOKIES", MyApplication.getInstance().MODE_PRIVATE);
                	String t = prefs.getString(c.getName(), "NULL");
                	SharedPreferences.Editor editor = prefs.edit();
                	if(t.equals("PHPSESSID")){
                		editor.putString(c.getName(), c.getValue());
                		editor.putString("CK_NAME", c.getName());
                		editor.putString("CK_DOMAIN", c.getDomain());
                		editor.putString("CK_EXPIRY", c.getExpiryDate().toString());
                		editor.putString("CK_PATH", c.getPath());
                		Log.d("COOKIES", c.getName() + ": " + c.getValue());
                	}
                	editor.commit();
                }
                
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