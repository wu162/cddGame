package com.example.utils;

public class CardType {
	public final static String
    None="none",
    Single="single",//��
    Double="double",//��
    Three="three",//������
    Four="four",//ը��
    ThreeAndTwo="threeAndTwo",//������
    Straight="straight",//˳��
    FourAndSingle="fourAndSingle",//�Ĵ���
    ColorStraight="colorStraight";//ͬ��˳
	
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
