package com.example.utils;

import android.app.Activity;
import android.media.MediaPlayer;

public class music {
	int src;
	MediaPlayer mMediaPlayer;
	
	public music(int src)
	{
		this.src=src;
	}
	
	public int getSrc() {
		return src;
	}

	public void setSrc(int src) {
		this.src = src;
	}

	public void start(Activity act)
	{
		//������Ҫ�ȹر���������
		mMediaPlayer=MediaPlayer.create(act, src);
		mMediaPlayer.start();
	}
	
	public void stop()
	{
		mMediaPlayer.stop();
	}
}
