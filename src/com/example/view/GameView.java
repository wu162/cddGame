package com.example.view;

import java.util.ArrayList;

import com.example.R;
import com.example.controller.GameController;
import com.example.model.ViewParams;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GameView extends LinearLayout{
	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	public void setListeners(GameController hc){
		findViewById(R.id.playcard).setOnClickListener(hc);
		findViewById(R.id.pass).setOnClickListener(hc);
	}
	
	public void updatePlayerCards(GameController hc,LinearLayout f,ImageButton btn,ViewParams viewparams) {
		btn.setId(viewparams.getId());
		btn.setImageResource(viewparams.getSrc());
		btn.setBackground(viewparams.getBackground());
		btn.setOnClickListener(hc);
        f.addView(btn);
        btn.setScaleType(viewparams.getScaletype());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) btn.getLayoutParams();
        layoutParams.topMargin = btn.getTop()-btn.getTop()+viewparams.getTopMargin();
        layoutParams.width=viewparams.getWidth();
        layoutParams.height=viewparams.getHeight();
        layoutParams.leftMargin = btn.getLeft()-btn.getLeft()+viewparams.getLeftMargin();
        btn.setLayoutParams(layoutParams);
	}
	
	public void updateCardShow(LinearLayout f,ImageView btn,ViewParams viewparams) {
		btn.setImageResource(viewparams.getSrc());
        f.addView(btn);
        btn.setScaleType(viewparams.getScaletype());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) btn.getLayoutParams();
        layoutParams.width=viewparams.getWidth();
        layoutParams.height=viewparams.getHeight();
        layoutParams.topMargin = btn.getTop()-btn.getTop()+viewparams.getTopMargin();
        btn.setLayoutParams(layoutParams);
	}
	
	public void setPCnum(int[] num)
	{
		TextView pcnum0=(TextView)findViewById(R.id.pc0num);
		TextView pcnum1=(TextView)findViewById(R.id.pc1num);
		TextView pcnum2=(TextView)findViewById(R.id.pc2num);
		
		char[] num0=String.valueOf(num[0]).toCharArray();
		char[] num1=String.valueOf(num[1]).toCharArray();
		char[] num2=String.valueOf(num[2]).toCharArray();
		
		pcnum0.setText(num0, 0, num0.length);
		pcnum1.setText(num1, 0, num1.length);
		pcnum2.setText(num2, 0, num2.length);
	}
}
