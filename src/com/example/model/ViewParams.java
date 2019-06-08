package com.example.model;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;

public class ViewParams { 
	public int id=-1;
	public int src=-1;
	public Drawable background=null;
	public int width=-1;
	public int height=-1;
	public int TopMargin=-1;
	public int LeftMargin=-1;
	public int RightMargin=-1;
	public int BottomMargin=-1;
	public ScaleType scaletype=ImageView.ScaleType.FIT_XY;
	
	
	public ViewParams(int id, int src, Drawable background, int width, int height, int topMargin, int leftMargin,
			int rightMargin, int bottomMargin, ScaleType scaletype) {
		super();
		this.id = id;
		this.src = src;
		this.background = background;
		this.width = width;
		this.height = height;
		TopMargin = topMargin;
		LeftMargin = leftMargin;
		RightMargin = rightMargin;
		BottomMargin = bottomMargin;
		this.scaletype = scaletype;
	}

	public ViewParams() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSrc() {
		return src;
	}
	public void setSrc(int src) {
		this.src = src;
	}
	public Drawable getBackground() {
		return background;
	}
	public void setBackground(Drawable background) {
		this.background = background;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getTopMargin() {
		return TopMargin;
	}
	public void setTopMargin(int topMargin) {
		TopMargin = topMargin;
	}
	public int getLeftMargin() {
		return LeftMargin;
	}
	public void setLeftMargin(int leftMargin) {
		LeftMargin = leftMargin;
	}
	public int getRightMargin() {
		return RightMargin;
	}
	public void setRightMargin(int rightMargin) {
		RightMargin = rightMargin;
	}
	public int getBottomMargin() {
		return BottomMargin;
	}
	public void setBottomMargin(int bottomMargin) {
		BottomMargin = bottomMargin;
	}

	public ScaleType getScaletype() {
		return scaletype;
	}

	public void setScaletype(ScaleType scaletype) {
		this.scaletype = scaletype;
	}
	
	
}