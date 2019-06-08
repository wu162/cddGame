package com.example.activity.implementation;

import java.util.ArrayList;

import com.example.R;
import com.example.activity.GameControllerListener;
import com.example.controller.GameController;
import com.example.model.GameData;
import com.example.model.ViewParams;
import com.example.utils.EndGameDialog;
import com.example.utils.EndGameListener;
import com.example.view.GameView;
import com.example.utils.utilsFun;
import com.example.utils.Rule;
import com.example.utils.music;
import com.example.utils.Round;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ImageView;

@SuppressLint("NewApi")
public class GameActivity extends Activity implements GameControllerListener , EndGameListener{

	public GameController gameController;
	public Round round;
	
	public GameData gamedata;
	private Round AIThread;
	public EndGameDialog endgameDialog;
	public music m;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.game_layout);
		
		m=new music(R.raw.game_music);
		m.start(this);
		
		gamedata=new GameData();
		
		//Activity links the view and the controller
		gameController = new GameController((GameView) this.findViewById(R.id.game), this);
		((GameView) this.findViewById(R.id.game)).setListeners(gameController);
		
		//调用游戏控制器开始游戏
		
		
		endgameDialog = new EndGameDialog(GameActivity.this);
		
		round=new Round(gamedata,this);
		
		//设置电脑的牌数
		setPCnum();
		
		utilsFun.initcardSelected(gamedata.cardSelected, gamedata.mycards.size());
		rePlayerCard();
		
	}
	
	@Override
	public void onDestroy()
	{
		endgameDialog.dismiss();
		super.onDestroy();
	}
	
	public void setPCnum()
	{
		gameController.setPCnum(new int[] {gamedata.getCom0Cards().size(),
				   						   gamedata.getCom1Cards().size(),
				   						   gamedata.getCom2Cards().size()});
	}
	
	
	
	
	public void rePlayerCard()
	{
		ArrayList<Boolean> cardSelected=gamedata.getCardSelected();
		int[] list=gamedata.getMyCard();
		cardSelected.clear();
		LinearLayout playcard=(LinearLayout)findViewById(R.id.cardlist);
		playcard.removeAllViews();
		int src=0;
		for(int i=0;i<list.length;i++)
		{
			cardSelected.add(false);
			src=utilsFun.getPic(list[i]);
			ImageButton cardbtn=new ImageButton(this);
			
			ViewParams viewparams=new ViewParams();
			viewparams.setId(i);
			viewparams.setSrc(src);
			viewparams.setBackground(null);
			viewparams.setScaletype(ImageView.ScaleType.FIT_XY);
			viewparams.setWidth(178);
			viewparams.setHeight(217);
			viewparams.setTopMargin(+60);
			if(i>0)
			{
				viewparams.setLeftMargin(-120);
			}
			else
			{
				viewparams.setLeftMargin(100);
			}
			gameController.addView(0, playcard, cardbtn, viewparams);
		}
		gamedata.setCardSelected(cardSelected);
	}
	
	@Override
	public void oncardSelected(int btnID) {
		ArrayList<Boolean> cardSelected=gamedata.getCardSelected();
		ImageButton btn=this.findViewById(btnID);
		LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) btn.getLayoutParams();
		if(cardSelected.get(btnID))
		{
			layoutParams.topMargin = btn.getTop()+20;
			cardSelected.set(btnID, false);
		}
		else
		{
			layoutParams.topMargin = btn.getTop()-20;
			cardSelected.set(btnID, true);
		}
		btn.setLayoutParams(layoutParams);
		
		gamedata.setCardSelected(cardSelected);
	}
	
	@Override
	public void onPlaycard()
	{
		ArrayList<Boolean> cardSelected=gamedata.getCardSelected();
		if(!cardSelected.contains(true))
		{
			return;
		}
		
		int[] list=gamedata.getMyCard();
		int[] newlist=utilsFun.getSelected(cardSelected, list, false);
		int[] showcard=utilsFun.getSelected(cardSelected, list, true);
		
		if(!Rule.ICanPop(utilsFun.int2List(showcard), gamedata.currentcards))
		{
			Log.v("rule", "no");
			return;
		}
		
		
		updateTableCard(showcard,3);
		gamedata.setCurrentCards(utilsFun.int2List(showcard));
		Log.v("cardselect", ""+gamedata.mycards.size());
		gamedata.setPass(false);
		
		if(newlist.length==0)
		{
			//玩家胜利
			showEndGameDialog("You have winned^_^");
		}
		Log.v("play", "start");
		round.run();
		if(gamedata.ifWin==1)
		{
			//电脑赢
			showEndGameDialog("You have failed-_-");
		}
		
		Log.v("play", "end");
		gamedata.setMyCards(newlist);
		rePlayerCard();
		utilsFun.initcardSelected(gamedata.cardSelected, gamedata.mycards.size());
		
	}
	
	@Override
	public void onPass()
	{
		int[] list=gamedata.getMyCard();
		gamedata.setPass(true);
		updateTableCard(new int[] {-1},3);
		round.run();
		if(gamedata.ifWin==1)
		{
			//电脑赢
			showEndGameDialog("You have failed-_-");
		}
		gamedata.setMyCards(list);     //确保没被更改
		utilsFun.initcardSelected(gamedata.cardSelected, gamedata.mycards.size());
	}
	
	
	
	public void updateTableCard(int[] list,int p)
	{
		int place=utilsFun.getPlace(p);
		LinearLayout cardshow=(LinearLayout)findViewById(place);
		cardshow.removeAllViews();
		
		//检测是否出了牌
		if(list[0]==-1)
		{
			ImageView pass=new ImageView(this);
			
			ViewParams viewparams=new ViewParams();
			viewparams.setSrc(R.drawable.pass);
			viewparams.setScaletype(ImageView.ScaleType.FIT_XY);
			viewparams.setWidth(150);
			viewparams.setHeight(75);
			//viewparams.setLeftMargin(0);
			gameController.addView(1, cardshow, pass, viewparams);
		}
		
		for(int i=0;i<list.length;i++)
		{
			int src=utilsFun.getPic(list[i]);
			
			ImageView card=new ImageView(this);
			
			ViewParams viewparams=new ViewParams();
			viewparams.setSrc(src);
			viewparams.setScaletype(ImageView.ScaleType.FIT_XY);
			viewparams.setWidth(128);
			viewparams.setHeight(152);
			if(i>0)
			{
				viewparams.setLeftMargin(-100);
			}
			else
			{
				viewparams.setLeftMargin(0);
			}
			gameController.addView(1, cardshow, card, viewparams);
		}
	}
	
	public void showEndGameDialog(String msg)
	{
		m.stop();
		endgameDialog.setTitle(msg);
		endgameDialog.setMessage("继续游戏?");
		endgameDialog.setEndGameListener(this);
		endgameDialog.show();
	}
	
	public void clearTable()
	{
		LinearLayout cardshow0=(LinearLayout)findViewById(R.id.pc0cardshow);
		LinearLayout cardshow1=(LinearLayout)findViewById(R.id.pc1cardshow);
		LinearLayout cardshow2=(LinearLayout)findViewById(R.id.pc2cardshow);
		LinearLayout cardshow3=(LinearLayout)findViewById(R.id.playercardshow);
		cardshow0.removeAllViews();
		cardshow1.removeAllViews();
		cardshow2.removeAllViews();
		cardshow3.removeAllViews();
	}
	
	@Override
	public void onEndDialog(boolean b)
	{
		gamedata.setConti(b);
		Log.v("final", ""+b);
		if(b)
		{
			Log.v("final", "win");
			m.start(this);
			gamedata=new GameData();
			round=new Round(gamedata,this);
			setPCnum();
			Log.v("final", "1");
			utilsFun.initcardSelected(gamedata.cardSelected, gamedata.mycards.size());
			Log.v("final", "2");
			rePlayerCard();
			clearTable();
			Log.v("final", "3");
		}
		else
		{
			Log.v("final", "finish");
			this.finish();
		}
	}
}