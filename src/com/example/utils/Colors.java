package com.example.utils;

public class Colors {
	public final static String 
	None="no",
	Square="sq",//·½Æ¬1
    Club="cl",//Ã·»¨2
    Heart="he",//ºìÐÄ3
    Spade="sp";//ºÚÌÒ4
	private String color;
	
	public Colors(String c){
		color = c;
	}
	
	public void setColor(String c){
		color = c;
	}
	
	public String getColor(){
		return color;
	}
}
