package com.example.view;

import com.example.R;
import com.example.controller.AboutController;
import com.example.controller.HelpController;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

public class AboutView extends LinearLayout{

	public AboutView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	public void setListeners(AboutController hc){
		findViewById(R.id.about_returnbutton).setOnClickListener(hc);
	}
}
