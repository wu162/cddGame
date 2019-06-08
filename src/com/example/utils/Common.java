package com.example.utils;

import java.util.ArrayList;
import java.util.List;


import java.util.Comparator;
import java.util.Collections;




public class Common {
	
	
	public static CardType jugdeType(List<Card> list){
		CardType type = Rule.jugdeType(list);
		return type;
	}
	
	//返回花色
	public static int getColor(Card card){
		return Integer.parseInt(card.CardName().substring(2,3));
	}
	
	//返回值
	public static int getValue(Card card){
		int i= Integer.parseInt(card.CardName().substring(3,card.CardName().length()));
		if(card.CardName().substring(3,card.CardName().length()).equals("2"))
			i+=13;
		if(card.CardName().substring(3,card.CardName().length()).equals("1"))
			i+=13;
		
		//int i = card.CardWeight();

		return i;
	}
	
	//得到最大相同数
	public static void getMax(Card_index card_index,List<Card> list){
		int count[]=new int[13];//1-13各算一种
		for(int i=0;i<13;i++)
			count[i]=0;
		for(int i=0,len=list.size();i<len;i++){
			count[Common.getValue(list.get(i))-3]++;				//注意这里可能有问题
		}
		for(int i=0;i<13;i++)
		{
			switch (count[i]) {
			case 1:
				card_index.a[0].add(i+1);
				break;
			case 2:
				card_index.a[1].add(i+1);
				break;
			case 3:
				card_index.a[2].add(i+1);
				break;
			case 4:
				card_index.a[3].add(i+1);
				break;
			}
		}
	}
	
	
	//拆牌
	public static Model getModel(List<Card> list){
		//先复制一个list
		List list2=new ArrayList<Card>(list);
		Model model=new Model();
		//------拆对子
		Common.getTwo(list2, model);
		//拆单
		Common.getSingle(list2, model);
		return model;
	}	
	
	//拆对子
	public static void getTwo(List<Card> list,Model model){
		List<Card> del=new ArrayList<Card>();//要删除的Cards
		//连续2张相同
		for(int i=0,len=list.size();i<len;i++){
			if(i+1<len&&Common.getValue(list.get(i))==Common.getValue(list.get(i+1)))
			{
				String s=list.get(i).CardName()+",";
				s+=list.get(i+1).CardName();
				model.a2.add(s);
				for(int j=i;j<=i+1;j++)
					del.add(list.get(j));
				i=i+1;
			}
		}
		list.removeAll(del);
	}
	
	
	//拆单牌
	public static void getSingle(List<Card> list,Model model){
		List<Card> del=new ArrayList<Card>();//要删除的Cards
		//1
		for(int i=0,len=list.size();i<len;i++){
				model.a1.add(list.get(i).CardName());
				del.add(list.get(i));
			}
		list.removeAll(del);
	}	
	
	
	//检查牌的是否能出(现在没用，废弃)
	public static int checkCards(List<Card> c,List<Card>[] current,int role){
		//找出当前最大的牌是谁出的,c是点选的牌
		List<Card> currentlist;
		if(current[(role+3)%4].size()>0){
			currentlist=current[(role+3)%4];
		}
		else if(current[(role+2)%4].size()>0){
			currentlist=current[(role+2)%4];
		}
		else{
			currentlist=current[(role+1)%4];
		}
		
		
		CardType cType=Common.jugdeType(c);//判断所选牌型
		
		//如果张数不同直接过滤
		if(c.size()!=currentlist.size())
			return 0;
		
		//比较我的出牌类型
		if(cType!=Common.jugdeType(currentlist))
		{			
			return 0;
		}
		
		//比较出的牌是否要大
		//单牌
		if(cType.getType()==CardType.Single){
			if(Common.getValue(c.get(0))>Common.getValue(currentlist.get(0)))				//比较值大小
			{
				 return 1;
			}
			else if(Common.getColor(c.get(0))>Common.getColor(currentlist.get(0)))			//值相同比较花色
			{
				return 1;
			}
		}
		
		
		//非规则牌型不通过
		//现在只能出单牌，其他牌型不通过
		return 0;
	}	
		
	
}

class Card_index{
	List a[]=new ArrayList[4];//单张
}
