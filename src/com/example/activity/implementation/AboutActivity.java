package com.example.activity.implementation;

import com.example.R;
import com.example.activity.AboutControllerListener;
import com.example.controller.AboutController;
import com.example.view.AboutView;
import com.example.view.HelpView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

@SuppressLint("NewApi")
public class AboutActivity extends Activity implements AboutControllerListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.about_layout);
		
		//Activity links the view and the controller
		AboutController aboutController = new AboutController((AboutView) this.findViewById(R.id.about), this);
		((AboutView) this.findViewById(R.id.about)).setListeners(aboutController);		
	}
	
	
	
	@Override
	public void onReturn() {
		this.finish();
	}
	
}
