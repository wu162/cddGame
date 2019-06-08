package com.example.activity.implementation;

import com.example.R;
import com.example.activity.HelpControllerListener;
import com.example.controller.HelpController;
import com.example.view.HelpView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;

@SuppressLint("NewApi")
public class HelpActivity extends Activity implements HelpControllerListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.help_layout);
		
		//Activity links the view and the controller
		HelpController helpController = new HelpController((HelpView) this.findViewById(R.id.help), this);
		//The Login controller will intercept the events of LoginView
		((HelpView) this.findViewById(R.id.help)).setListeners(helpController);		
	}
	
	
	
	/**
	 * Controller calls this method if the login was successful
	 */
	@Override
	public void onReturn() {
		this.finish();
	}
	
	@Override
	public void onRadio(ImageView v,int checkedId) {
		switch(checkedId) {
		case R.id.abstractbutton:
			v.setImageResource(R.drawable.help1);
			break;
		case R.id.gesturebutton:
			v.setImageResource(R.drawable.help2);
			break;
		case R.id.rulebutton:
			v.setImageResource(R.drawable.help2);
			break;
		case R.id.cardtypebutton:
			v.setImageResource(R.drawable.help3);
			break;
		case R.id.scorecalbutton:
			v.setImageResource(R.drawable.help3);
			break;
		}
	}
}
