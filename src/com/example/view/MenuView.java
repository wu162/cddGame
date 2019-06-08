package com.example.view;

import com.example.R;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;


public class MenuView extends LinearLayout{

	public MenuView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	public void setListeners(OnClickListener onClickListener){
		findViewById(R.id.startbutton).setOnClickListener(onClickListener);
		findViewById(R.id.helpbutton).setOnClickListener(onClickListener);
		findViewById(R.id.aboutbutton).setOnClickListener(onClickListener);
	}
}
