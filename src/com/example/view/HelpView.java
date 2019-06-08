package com.example.view;

import com.example.R;
import com.example.controller.HelpController;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

public class HelpView extends LinearLayout{

	public HelpView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	public void setListeners(HelpController hc){
		findViewById(R.id.returnbutton).setOnClickListener(hc);
		((RadioGroup)findViewById(R.id.helpradio)).setOnCheckedChangeListener(hc);
	}
}
