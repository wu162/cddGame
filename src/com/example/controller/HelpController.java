package com.example.controller;

import com.example.R;
import com.example.activity.HelpControllerListener;
import com.example.activity.MenuControllerListener;
import com.example.constant.ErrorConstants;
import com.example.view.HelpView;
import com.example.view.MenuView;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

/**
 * LoginController intercepts the on click login button event, verify the inputs 
 * @author karina sokolova
 *
 */
@SuppressLint("NewApi")
public class HelpController implements OnClickListener,OnCheckedChangeListener {

	private final String TAG = "Help controller";
	
	private HelpView helpView;
	private HelpControllerListener listener;

	public HelpController(HelpView helpView, HelpControllerListener listener) {
		this.helpView = helpView;
		this.listener = listener;
	}

	/**
	 * Login button was clicked
	 */
	@Override
	public void onClick(View v) {
		ImageView Pic=helpView.findViewById(R.id.helpPic);
		switch(v.getId()) {
		case R.id.returnbutton:
			listener.onReturn();
			break;
		}
	}
	
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		ImageView Pic=helpView.findViewById(R.id.helpPic);
		listener.onRadio(Pic, checkedId);
	}

}
