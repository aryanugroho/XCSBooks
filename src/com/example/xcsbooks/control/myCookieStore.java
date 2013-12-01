package com.example.xcsbooks.control;

import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

public class myCookieStore implements CookieStore {
	public static final String LOGTAG = "COOKIE";
	private Map<String, Map<String, String>> mapCookies = new HashMap<String, Map<String, String>>();
	private final SharedPreferences sharedPrefs;
	
	public myCookieStore(Context c){
		sharedPrefs = c.getSharedPreferences("LOGIN_CREDENTIALS", c.MODE_PRIVATE);
	}
	
	@Override
	public void add(URI uri, HttpCookie cookie) {
		String domain = cookie.getDomain();
		
		Map<String, String> cookies = mapCookies.get(domain);
		if(cookies == null){
			cookies = new HashMap<String, String>();
			mapCookies.put(domain, cookies);
		}
		cookies.put(cookie.getName(), cookie.getValue());
		
		if(cookie.getName().startsWith("PHPSESSID") && !cookie.getValue().equals("")){
			Editor e = sharedPrefs.edit();
			e.putString("SESSION", cookie.toString());
			e.commit();
		}
	}

	@Override
	public List<HttpCookie> get(URI uri) {
		List<HttpCookie> cookieList = new ArrayList<HttpCookie>();
		String domain = uri.getHost();
		
		Map<String,String> cookies = mapCookies.get(domain);
		if(cookies == null){
			cookies = new HashMap<String, String>();
			mapCookies.put(domain, cookies);
		}
		
		for(Map.Entry<String, String> entry : cookies.entrySet()) {
			cookieList.add(new HttpCookie(entry.getKey(), entry.getValue()));
		}
		return cookieList;
	}

	@Override
	public List<HttpCookie> getCookies() {
		Set<String> mapKeys = mapCookies.keySet();
		
		List<HttpCookie> result = new ArrayList<HttpCookie>();
		for(String key : mapKeys) {
			Map<String, String> cookies = mapCookies.get(key);
			for(Map.Entry<String, String> entry : cookies.entrySet()){
				result.add(new HttpCookie(entry.getKey(), entry.getValue()));
				Log.i(LOGTAG, "returning cookie: " + entry.getKey() + "= " + entry.getValue());
			}
		}
		return result;
	}

	@Override
	public List<URI> getURIs() {
		Set<String> keys = mapCookies.keySet();
		List<URI> uris = new ArrayList<URI>(keys.size());
		
		for(String key : keys){
			URI uri = null;
			try{
				uri = new URI(key);
			} catch(URISyntaxException e) {
				e.printStackTrace();
			}
			uris.add(uri);
		}
		return uris;
	}

	@Override
	public boolean remove(URI uri, HttpCookie cookie) {
		String domain = cookie.getDomain();
		Map<String, String> lstCookies = mapCookies.get(domain);
		if(lstCookies == null)
			return false;
		
		return lstCookies.remove(cookie.getName()) != null;
	}

	@Override
	public boolean removeAll() {
		mapCookies.clear();
		return true;
	}

}
