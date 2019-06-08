package com.example.activity.implementation;

import com.example.R;
import com.example.activity.MenuControllerListener;
import com.example.controller.MenuController;
import com.example.utils.music;
import com.example.view.MenuView;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * Activity which displays a login screen to the user.
 */
@SuppressLint("NewApi")
public class MenuActivity extends Activity implements MenuControllerListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.menu_layout);
		
		//Activity links the view and the controller
		MenuController menuController = new MenuController((MenuView) this.findViewById(R.id.menu), this);
		//The Login controller will intercept the events of LoginView
		((MenuView) this.findViewById(R.id.menu)).setListeners(menuController);	
		
		//m=new music(R.raw.menu);
		//m.start(this);
		
	}
	
	@Override
	public void onStartGame() {
		//m.stop();
		Intent intent = new Intent(this, GameActivity.class);
		this.startActivity(intent);
	}
	
	@Override
	public void onHelp() {
		//We open a new screen
		Intent intent = new Intent(this, HelpActivity.class);
		this.startActivity(intent);
	}
	
	@Override
	public void onAbout() {
		//We open a new screen
		Intent intent = new Intent(this, AboutActivity.class);
		this.startActivity(intent);
	}
}
