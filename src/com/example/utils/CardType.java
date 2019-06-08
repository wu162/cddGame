package com.example.utils;

public class CardType {
	public final static String
    None="none",
    Single="single",//单
    Double="double",//对
    Three="three",//三不带
    Four="four",//炸弹
    ThreeAndTwo="threeAndTwo",//三带二
    Straight="straight",//顺子
    FourAndSingle="fourAndSingle",//四带单
    ColorStraight="colorStraight";//同花顺
	
	private String type;
	
	public CardType(String t){
		type = t;
	}
	
	public void setType(String t){
		type = t;
	}
	
	public String getType(){
		return type;
	}
}
