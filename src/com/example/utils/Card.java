package com.example.utils;

import java.lang.String;





public class Card {
    //名字
    //花色
    //权值
    //属于谁
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
    /// 卡牌名字
    /// </summary>
    public String CardName(){
            return cardName;
    }


    //卡牌花色
    public String CardColor(){
            return cardColor.getColor();
    }

    //卡牌权值
    public int CardWeight()
    {
            return cardWeight.getWeight();
    }
    
    
    public int CardID(){
    	return cardID;
    }
    
    
}
