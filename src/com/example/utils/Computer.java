package com.example.utils;

import java.util.ArrayList;
import java.util.List;



public class Computer {

	private
	Round control;
	List<Card> cards;
	
	public Computer(Round c){
		cards = new ArrayList();
		control = c;
	}
	
	//设置这个电脑拥有的卡组
	public void setCards(List<Card> c){
		cards=c;
	}
	
	//添加加卡（一张）
	public void addCard(Card c){
		cards.add(c);
	}
	
	//返回这个电脑拥有的卡组
	public List getCards(){
		return cards;
	}
	
	//电脑走牌
	public boolean ShowCard() {
		Model model = Common.getModel(cards);
		
		
		// 待走的牌
		List<String> readyToShowList = new ArrayList();
		
		
		// 如果是主动出牌
		if (control.record==3) 
		{
			// 有单出单
			if (model.a1.size() > 0) {
				readyToShowList.add(model.a1.get(model.a1.size() - 1));
			} 
			// 有对子出对子
			/*else if (model.a2.size() > 0) {
				readyToShowList.add(model.a2.get(model.a2.size() - 1));
			}*/
			else if (model.a2.size() > 0) {
				//readyToShowList.add(model.a2.get(model.a2.size() - 1));
				//for(int len=model.a2.size(),i=len-1;i>=0;i--)
				String name[]=model.a2.get(model.a2.size()-1).split(",");
				readyToShowList.add(name[0]);
				readyToShowList.add(name[1]);
			}
			
			
		}
		
		// 如果是跟牌，获得上一个玩家所出的牌
		else {
			
			List<Card> curCards=control.currentcards;
			
			CardType cType=Common.jugdeType(curCards);
			
			//如果是单牌
			if(cType.getType()==CardType.Single)
			{
				AI_1(model.a1, curCards, readyToShowList/*, control.role*/);
			}
			//如果是对子
		    else if(cType.getType()==CardType.Double)
			{
				AI_2(model.a2, curCards, readyToShowList/*, role*/);
			}
		
		}

		//输出玩家号
		//System.out.println("player"+role+"         player cards"+Main.playerList[role].size());
		
		
		if (readyToShowList.size() > 0) {
			// 将name转换成Card
			List<Card> cards1 = getCardByName(cards,readyToShowList);
			
			//打出的卡发给controler
			control.currentcards=cards1;
			control.record=0;
			
			//移除电脑打出的卡
			for(int w = 0 , len = cards1.size() ; w < len ; w++ ){
				cards.remove(cards1.get(w));
				//System.out.println(cards.get(w).CardName());
			}
			return true;
		} 
		else {
			//System.out.println("pass");
			//输出“pass”
			control.record++;
			return false;
		}
	}
	
	
	//单牌
	public void AI_1(List<String> model,List<Card> player,List<String> list/*,int role*/){
				
		
		for(int len=model.size(),i=len-1;i>=0;i--)
		{
			if(MyTools.getValueInt(model.get(i))>Common.getValue(player.get(0)))
			{
				list.add(model.get(i));
				break;
			}
		}
	}
	
	//对子
	public void AI_2(List<String> model,List<Card> player,List<String> list/*,int role*/){
					
		for(int len=model.size(),i=len-1;i>=0;i--)
		{
			if(MyTools.getValueInt(model.get(i))>Common.getValue(player.get(0)))
			{
				String name[]=model.get(i).split(",");
				list.add(name[0]);
				list.add(name[1]);
				break;
			}
		}
	}
	
	// 按name获得Card，方便从Model取出
	public List getCardByName(List<Card> list, List<String> l) {
		List<Card> cardsList = new ArrayList();
		int j = 0;
		String temp;
		for (int i = 0, len = list.size(); i < len; i++) {
			temp = list.get(i).CardName();
			if (j < l.size() && temp.equals(l.get(j))) {
				cardsList.add(list.get(i));
				i = -1;
				j++;
			}
		}
		return cardsList;
	}
	

}
