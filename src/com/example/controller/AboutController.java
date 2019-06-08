package com.example.controller;

import com.example.R;
import com.example.activity.AboutControllerListener;
import com.example.activity.HelpControllerListener;
import com.example.activity.MenuControllerListener;
import com.example.constant.ErrorConstants;
import com.example.view.AboutView;
import com.example.view.HelpView;
import com.example.view.MenuView;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;


@SuppressLint("NewApi")
public class AboutController implements OnClickListener {

	private final String TAG = "Help controller";
	
	private AboutView aboutView;
	private AboutControllerListener listener;

	public AboutController(AboutView aboutView, AboutControllerListener listener) {
		this.aboutView = aboutView;
		this.listener = listener;
	}

	
	@Override
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.about_returnbutton:
			listener.onReturn();
			break;
		}
	}

}
