package com.example.utils;

public class Colors {
	public final static String 
	None="no",
	Square="sq",//��Ƭ1
    Club="cl",//÷��2
    Heart="he",//����3
    Spade="sp";//����4
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
