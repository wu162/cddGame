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
	
	//�����������ӵ�еĿ���
	public void setCards(List<Card> c){
		cards=c;
	}
	
	//��Ӽӿ���һ�ţ�
	public void addCard(Card c){
		cards.add(c);
	}
	
	//�����������ӵ�еĿ���
	public List getCards(){
		return cards;
	}
	
	//��������
	public boolean ShowCard() {
		Model model = Common.getModel(cards);
		
		
		// ���ߵ���
		List<String> readyToShowList = new ArrayList();
		
		
		// �������������
		if (control.record==3) 
		{
			// �е�����
			if (model.a1.size() > 0) {
				readyToShowList.add(model.a1.get(model.a1.size() - 1));
			} 
			// �ж��ӳ�����
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
		
		// ����Ǹ��ƣ������һ�������������
		else {
			
			List<Card> curCards=control.currentcards;
			
			CardType cType=Common.jugdeType(curCards);
			
			//����ǵ���
			if(cType.getType()==CardType.Single)
			{
				AI_1(model.a1, curCards, readyToShowList/*, control.role*/);
			}
			//����Ƕ���
		    else if(cType.getType()==CardType.Double)
			{
				AI_2(model.a2, curCards, readyToShowList/*, role*/);
			}
		
		}

		//�����Һ�
		//System.out.println("player"+role+"         player cards"+Main.playerList[role].size());
		
		
		if (readyToShowList.size() > 0) {
			// ��nameת����Card
			List<Card> cards1 = getCardByName(cards,readyToShowList);
			
			//����Ŀ�����controler
			control.currentcards=cards1;
			control.record=0;
			
			//�Ƴ����Դ���Ŀ�
			for(int w = 0 , len = cards1.size() ; w < len ; w++ ){
				cards.remove(cards1.get(w));
				//System.out.println(cards.get(w).CardName());
			}
			return true;
		} 
		else {
			//System.out.println("pass");
			//�����pass��
			control.record++;
			return false;
		}
	}
	
	
	//����
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
	
	//����
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
	
	// ��name���Card�������Modelȡ��
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
