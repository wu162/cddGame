package com.example.utils;

import java.util.List;

import android.util.Log;

public class Rule {
	
	
	
    //�ж��Ƿ�Ϊ��
    public static boolean isSingle(List<Card> cards)
    {
        return cards.size() == 1;
    }

    //�ж��Ƿ�Ϊ��
    public static boolean isDouble(List<Card> cards)
    {
        if (cards.size() == 2)
        {
            if (cards.get(0).CardWeight() == cards.get(1).CardWeight())
            {
                return true;
            }
        }
        return false;
    }

    //�ж��Ƿ�Ϊ������
    public static boolean isThree(List<Card> cards)
    {
        if (cards.size() == 3)
        {
            if (cards.get(0).CardWeight() == cards.get(1).CardWeight() && cards.get(1).CardWeight() == cards.get(2).CardWeight())
            {
                return true;
            }

        }
        return false;
    }

    //�ж��Ƿ���˳�� 34567
    public static boolean isStraight(List<Card> cards)
    {
        if (cards.size() !=5)
            return false;
        for (int i = 0; i < cards.size() - 1; i++)
        {
            if (cards.get(i+1).CardWeight() - cards.get(i).CardWeight() != 1)
                return false;
            if (cards.get(i).CardWeight() > CardWeight.One || cards.get(i+1).CardWeight() > CardWeight.One)
                return false;
        }
        return true;
    }
    //�ж��Ƿ���ͬ��˳
    public static boolean isColorStraight(List<Card> cards)
    {
        if (cards.size() != 5)
            return false;
        for (int i = 0; i < cards.size() - 1; i++)
        {
            if (cards.get(i+1).CardWeight() - cards.get(i).CardWeight() != 1)
                return false;
            if (cards.get(i).CardWeight() > CardWeight.One || cards.get(i+1).CardWeight() > CardWeight.One)
                return false;
        }
        for (int i = 0; i < cards.size() - 1; i++)
        {
            if (cards.get(i+1).CardColor() != cards.get(i).CardColor())
                return false;
        }
            return true;
    }

    //�ж��Ƿ����Ĵ��� 22221 12222
    public static boolean isFourAndSingle(List<Card> cards)
    {
        if (cards.size() != 5)
            return false;
        for (int i = 0; i < cards.size(); i++)
        {
            if (cards.get(0).CardWeight() == cards.get(1).CardWeight() && cards.get(1).CardWeight() == cards.get(2).CardWeight()
           && cards.get(2).CardWeight() == cards.get(3).CardWeight())
                return true;
            if (cards.get(1).CardWeight() == cards.get(2).CardWeight() && cards.get(2).CardWeight() == cards.get(3).CardWeight()
               && cards.get(3).CardWeight() == cards.get(4).CardWeight())
                return true;
        }

        return false;
    }

    //�ж��Ƿ��������� 33344 44333
    public static boolean isThreeAndTwo(List<Card> cards)
    {
        if (cards.size() != 5)
            return false;
        if (cards.get(0).CardWeight() == cards.get(1).CardWeight() && cards.get(1).CardWeight() == cards.get(2).CardWeight() && cards.get(2).CardWeight() != cards.get(3).CardWeight())
            return true;
        else if (cards.get(0).CardWeight() == cards.get(1).CardWeight() && cards.get(2).CardWeight() == cards.get(3).CardWeight() && cards.get(3).CardWeight() == cards.get(4).CardWeight())
            return true;
        return false;
    }

    //�ж��Ƿ����Ĳ���
    public static boolean isFour(List<Card> cards)
    {
        if (cards.size() != 4){
            return false;
        }
        if (cards.get(0).CardWeight() != cards.get(1).CardWeight()){
            return false;
        }
        if (cards.get(1).CardWeight() != cards.get(2).CardWeight()){
            return false;
        }
        if (cards.get(2).CardWeight() != cards.get(3).CardWeight()){
            return false;
        }
        else
        return true;
    }
    
    
    //�������
    public static CardType jugdeType(List<Card> cards)
    {
    	CardType type = new CardType(CardType.None);
        switch (cards.size())
        {
            case 1://��
                if (isSingle(cards))
                {
                    type.setType(CardType.Single);
                }
                break;
            case 2: //��
                if (isDouble(cards))
                {
                    type.setType(CardType.Double);
                }

                break;
            case 3://������
                if (isThree(cards))
                {
                    type.setType(CardType.Three);
                }
                break;

            case 5://˳�� ������ �Ĳ���  ͬ��˳
                if (isStraight(cards))
                {
                    type.setType(CardType.Straight);
                }
                else if (isThreeAndTwo(cards))
                {
                    type.setType(CardType.ThreeAndTwo);
                }
                else if (isFour(cards))
                {
                    type.setType(CardType.Four);
                }
                else if (isColorStraight(cards))
                {
                    type.setType(CardType.ColorStraight);
                }
                break;
        }
        return type;
    }
    
    
    
    
    
  //�ж��Ƿ��ܳ��ƣ��ڲ������ã������Ѿ��ò����ˣ�
    public static boolean CanPop(List<Card> mycards, List<Card> computercard)
    {
    	
    	boolean can = false;
    	
    	
        CardType myType=jugdeType(mycards);
        
        
        if(myType.getType()==CardType.None){
    		return can;
        }
        else if(computercard.size()==0){
        	return true;
        }
        else{
        	CardType computerType=jugdeType(computercard);
        	if(myType==computerType){
        		can=true;             //����Ҫ�Ӷ���
        	}
        }
        
        return can;
    }
    
    
    
    //�ж��Ƿ��ܳ��ƣ��ⲿ�ã�
    public static boolean ICanPop(List<Integer> m, List<Integer> c)
    {
    	List<Card> mycards = MyTools.remapping(m);
    	List<Card> computercard = MyTools.remapping(c);
    	
    	boolean can = false;
    	
    	
        CardType myType=Rule.jugdeType(mycards);
        
        
        if(myType.getType()==CardType.None){
    		return can;
        }
        else if(computercard.size()==0){       
        	return true;
        }
        else{
        	CardType computerType=Rule.jugdeType(computercard);
        	
        	
        	boolean bool1=(myType==computerType);
        	Log.v("rule111", ""+bool1);
        	Log.v("rule111", myType.getType());
        	Log.v("rule111", computerType.getType());
        	boolean bool2=(mycards.get(0).CardWeight()>computercard.get(0).CardWeight());
        	Log.v("rule111", ""+bool2);
        	
        	if(myType.getType().equals(computerType.getType())/*&&mycards.get(0).CardWeight()>computercard.get(0).CardWeight()*/){
        		if(myType.getType().equals(CardType.Single)){
        			if(mycards.get(0).CardWeight()>computercard.get(0).CardWeight()){
            			can = true;
            		}
        			else if(mycards.get(0).CardWeight()==computercard.get(0).CardWeight()&&Common.getColor(mycards.get(0))>Common.getColor(computercard.get(0))){
        				can = true;
        			}
        		}
        		else if(myType.getType().equals(CardType.Double)){
        			if(mycards.get(0).CardWeight()>computercard.get(0).CardWeight()){
        				can = true;
        			}
        		}
        		
        		//can=true;             //�������Ҫ�Ӷ���
        	}
        }
        
        return can;
    }    
    
    
    
}
