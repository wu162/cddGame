package com.example.controller;

import java.util.ArrayList;

import com.example.R;
import com.example.activity.AboutControllerListener;
import com.example.activity.GameControllerListener;
import com.example.activity.implementation.GameActivity;
import com.example.model.GameData;
import com.example.model.ViewParams;
import com.example.utils.utilsFun;
import com.example.view.AboutView;
import com.example.view.GameView;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

@SuppressLint("NewApi")
public class GameController implements OnClickListener {
	
	private GameView gameView;
	private GameControllerListener listener;

	public GameController(GameView gameView, GameControllerListener listener) {
		this.gameView = gameView;
		this.listener = listener;
	}

	
	@Override
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.playcard:
			listener.onPlaycard();
			break;
		case R.id.pass:
			listener.onPass();
			break;
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
		case 10:
		case 11:
		case 12:
			Log.v("btn", "btn6");
			listener.oncardSelected(v.getId());
			break;
		}
	}
	
	public void addView(int type,LinearLayout f,View v,ViewParams viewparams)
	{
		switch(type)
		{
		case 0:
			gameView.updatePlayerCards(this, f, (ImageButton)v, viewparams);
			break;
		case 1:
			gameView.updateCardShow(f, (ImageView)v, viewparams);
			break;
		}
	}
	
	public void setPCnum(int[] num)
	{
		gameView.setPCnum(num);
	}

}
