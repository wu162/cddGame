package com.example.controller;

import com.example.activity.MenuControllerListener;
import com.example.constant.ErrorConstants;
import com.example.view.MenuView;

import com.example.R;
import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * LoginController intercepts the on click login button event, verify the inputs 
 * @author karina sokolova
 *
 */
@SuppressLint("NewApi")
public class MenuController implements OnClickListener{

	private final String TAG = "Login controller";
	
	private MenuView menuView;
	private MenuControllerListener listener;
	

	public MenuController(MenuView menuView, MenuControllerListener listener) {
		this.menuView = menuView;
		this.listener = listener;
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.startbutton:
			listener.onStartGame();
			break;
		case R.id.helpbutton:
			listener.onHelp();
			break;
		case R.id.aboutbutton:
			listener.onAbout();
			break;
		}
	}

}
