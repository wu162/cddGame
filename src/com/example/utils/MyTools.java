package com.example.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class MyTools {

	// 通过name估值
	public static int getValueInt(String n) {
		String name[]=n.split(",");
		String s=name[0];
		int i = Integer.parseInt(s.substring(3, s.length()));
		if (s.substring(3, s.length()).equals("1") || s.substring(3, s.length()).equals("2"))
			i += 13;
		return i;
		
		/*
		 * 
		String name[]=n.split(",");
		String s=name[0];
		int i=Integer.parseInt(s.substring(2, s.length()));
		if(s.substring(2, s.length()).equals("1")||s.substring(2, s.length()).equals("2"))
			i+=13;
		return i;
		 */
	}

	// 通过name获得卡
		public static Card getCardByName(String s) {
			int i = Integer.parseInt(s.substring(2, s.length()));
			Card card;
			int weight;
			int colors;
			if(i>100){
				weight=i%100;
				colors=i/100;
			}
			else{
				weight=i%10;
				colors=i/10;
			}
			Integer id = (colors-1)*13+weight-1;
			
			return MyTools.getCardByID(id);
			/*
			 * 
			String name[]=n.split(",");
			String s=name[0];
			int i=Integer.parseInt(s.substring(2, s.length()));
			if(s.substring(2, s.length()).equals("1")||s.substring(2, s.length()).equals("2"))
				i+=13;
			return i;
			 */
		}
		
	// 对list排序
	public static void order(List<Card> list) {
		Collections.sort(list, new Comparator<Card>() {
			public int compare(Card o1, Card o2) {
				// TODO Auto-generated method stub
				int a1 = Integer.parseInt(o1.CardName().substring(2, 3));// 花色
				int a2 = Integer.parseInt(o2.CardName().substring(2, 3));
				int b1 = Integer.parseInt(o1.CardName().substring(3, o1.CardName().length()));// 数值
				int b2 = Integer.parseInt(o2.CardName().substring(3, o2.CardName().length()));
				
				/*int a1 = Integer.parseInt(o1.CardColor());//花色
				int a2 = Integer.parseInt(o2.CardColor());
				int b1 = o1.CardWeight();//数值
				int b2 = o2.CardWeight();
				*/
				int flag = 0;
				// 如果是A或者2
				if (b1 == 1)
					b1 += 20;
				if (b2 == 1)
					b2 += 20;
				if (b1 == 2)
					b1 += 30;
				if (b2 == 2)
					b2 += 30;
					
				flag = b2 - b1;
				if (flag == 0)
					return a2 - a1;
				else {
					return flag;
				}
			}
		});
	}

	//由卡数组获得卡ID数组
	public static List mapping(List<Card> list){
		List<Integer> l=new ArrayList();
		int temp=0;
		for(int i=0,len=list.size();i<len;i++){
			temp=new Integer(list.get(i).CardID());
			l.add(temp);
		}	
		return l;
	}
	
	//由卡ID数组获得卡数组
	public static List remapping(List<Integer> list){
		List<Card> l = new ArrayList();
		Card temp;
		for(int i=0,len=list.size();i<len;i++){
			temp=getCardByID(list.get(i));
			l.add(temp);
		}
		return l;
	}
	
	//由卡ID获得卡
	public static Card getCardByID(Integer index){
		if(index==0)
			return new Card(Colors.Square +1+1,new Colors(Colors.Square), new CardWeight(CardWeight.One), index );
		else{
			int color=index/13+1;
			int weight =index%13 + 1;
			for (int i = 1; i <= 4; i++) {
				if(i==color)
					for (int j = 1; j <= 13; j++) {
						if(j==weight)
						{
							if (i == 1)
							{
								if(j==1){
									return new Card(Colors.Square +color + weight,new Colors(Colors.Square), new CardWeight(CardWeight.One), index );
								}
								else if(j==2){
									return new Card(Colors.Square +color + weight,new Colors(Colors.Square), new CardWeight(CardWeight.Two), index );
								}
								else
								return new Card(Colors.Square + color + weight, new Colors(Colors.Square), new CardWeight(weight), index);
							} 
							else if (i == 2) 
							{
								if(j==1){
									return new Card(Colors.Club +color + weight,new Colors(Colors.Club), new CardWeight(CardWeight.One), index );
								}
								else if(j==2){
									return new Card(Colors.Club +color + weight,new Colors(Colors.Club), new CardWeight(CardWeight.Two), index );
								}
								else
								return new Card(Colors.Club + color + weight, new Colors(Colors.Club), new CardWeight(weight), index);
							} 
							else if (i == 3) 
							{
								if(j==1){
									return new Card(Colors.Heart +color + weight,new Colors(Colors.Heart), new CardWeight(CardWeight.One), index );
								}
								else if(j==2){
									return new Card(Colors.Heart +color + weight,new Colors(Colors.Heart), new CardWeight(CardWeight.Two), index );
								}
								else
								return new Card(Colors.Heart + color + weight, new Colors(Colors.Heart), new CardWeight(weight), index);
							} 
							else if (i == 4) 
							{
								if(j==1){
									return new Card(Colors.Spade +color + weight,new Colors(Colors.Spade), new CardWeight(CardWeight.One), index );
								}
								else if(j==2){
									return new Card(Colors.Spade +color + weight,new Colors(Colors.Spade), new CardWeight(CardWeight.Two), index );
								}
								else
								return new Card(Colors.Spade + color + weight, new Colors(Colors.Spade), new CardWeight(weight), index);
							}
						}
					}
			}
		}
		return new Card(Colors.None+0+0,new Colors(Colors.None),new CardWeight(0),99);//白卡
	}
	
	
}
