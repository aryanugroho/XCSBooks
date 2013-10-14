package com.example.xcsbooks;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import control.LoginControl;

public class Fragment_Home_Logado extends Fragment{

	public View onCreateView(LayoutInflater inflater, final ViewGroup container,
			   Bundle savedInstanceState) {
		View myFragmentView = inflater.inflate(R.layout.fragment_home, container, false);
		
		TextView tv = (TextView) myFragmentView.findViewById(R.id.fragLogado_txtMsgNomeUsuario);
		tv.setText("Bem Vindo, X");
		
		return myFragmentView;
	}
}
