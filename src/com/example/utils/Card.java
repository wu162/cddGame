package com.example.utils;

import java.lang.String;





public class Card {
    //����
    //��ɫ
    //Ȩֵ
    //����˭
    private String cardName;
    private Colors cardColor;
    private CardWeight cardWeight;
    private int cardID;

    public Card(String _name,Colors _color,CardWeight _weight,int id)
    {
        this.cardName = _name;
        this.cardColor = _color;
        this.cardWeight = _weight; 
        cardID=id;
    }
    
    
    /// <summary>
    /// ��������
    /// </summary>
    public String CardName(){
            return cardName;
    }


    //���ƻ�ɫ
    public String CardColor(){
            return cardColor.getColor();
    }

    //����Ȩֵ
    public int CardWeight()
    {
            return cardWeight.getWeight();
    }
    
    
    public int CardID(){
    	return cardID;
    }
    
    
}
