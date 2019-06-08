package com.example.activity;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;

public interface HelpControllerListener {
	public void onReturn();
	public void onRadio(ImageView v,int checkedId);
}
