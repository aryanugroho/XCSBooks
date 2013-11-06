package com.example.xcsbooks.control;

import android.util.Log;

public class ResponseControl {
	public static Integer parseInt(String s){
		try{
			return Integer.valueOf(s.trim());
		} catch (NumberFormatException e) {
			Log.d("INT_PARSER", "String length: " + s.length());
			Log.d("INT_PARSER", "Value: " + s + " cannot be parsed");
			return null;
		}
	}
}
