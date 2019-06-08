package com.example.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.activity.implementation.GameActivity;
import com.example.model.GameData;

import android.util.Log;

public class Round {

	int record;
	List<Card> currentcards;
	List<Card> mycards;
	Computer com[] = new Computer[3];
	List<Card> card;
	List<Card> temp;
	GameData mydata;
	GameActivity gameActivity;

	public Round(GameData d , GameActivity a) {
		currentcards = new ArrayList();
		mycards = new ArrayList();
		card = new ArrayList();
		com[0] = new Computer(this);
		com[1] = new Computer(this);
		com[2] = new Computer(this);
		record = 0;
		CardInit();
		mydata = d;
		mydata.setIfWin(0);
		gameActivity = a;
		ShuffleCard();// ϴ�Ʋ�����
		transData();
	}

	public void ReStar() {
		currentcards.clear();
		mycards.clear();
		mydata.getMyCards().clear();
		com[0].getCards().clear();
		com[1].getCards().clear();
		com[2].getCards().clear();
		record = 0;
		mydata.setIfWin(0);
		ShuffleCard();// ϴ�Ʋ�����
		transData();
	}

	public void transData() {
		mydata.setMyCards(MyTools.mapping(mycards));
		mydata.setCurrentCards(MyTools.mapping(currentcards));
		mydata.setCom0Cards(MyTools.mapping(com[0].getCards()));
		mydata.setCom1Cards(MyTools.mapping(com[1].getCards()));
		mydata.setCom2Cards(MyTools.mapping(com[2].getCards()));
	}

	// ��ʼ�˻غ�
	public void run() {
		currentcards=MyTools.remapping(mydata.getCurrentCards());	
		if(!mydata.getPass())
		{
			record=0;
			mydata.setRecord(record);
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////�ҳ�����
				
		}
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////// ��pass
		else {
			record++;
			mydata.setRecord(record);
		}
		////////////////////////////////////////////////////////����0����
		boolean whetherOut0=com[0].ShowCard();
		transData();
		mydata.setRecord(record);
		///////////////////////////////////////////////////////////////////////////////////////////////////�˴������˳����Ʋ������ݸ�gamedata
		if(whetherOut0)
		{
			gameActivity.updateTableCard(utilsFun.List2int(mydata.getCurrentCards()),0);
		}
		else
		{
			gameActivity.updateTableCard(new int[] {-1},0);
		}
		gameActivity.setPCnum();
		Log.v("play", "0");
			
		whetherWin();// �ж���Ӯ
		//����ͣ��ʱ��
		Log.v("play", "1");

		////////////////////////////////////////////////////////����1����
		boolean whetherOut1=com[1].ShowCard();
		transData();
		mydata.setRecord(record);
		///////////////////////////////////////////////////////////////////////////////////////////////////�˴������˳����Ʋ������ݸ�gamedata
		if(whetherOut1)
		{
			gameActivity.updateTableCard(utilsFun.List2int(mydata.getCurrentCards()),1);
		}
		else
		{
			gameActivity.updateTableCard(new int[] {-1},1);
		}
		gameActivity.setPCnum();
			

		whetherWin();// �ж���Ӯ
		Log.v("play", "2");
		
		
		////////////////////////////////////////////////////////����2����
		boolean whetherOut2=com[2].ShowCard();
		transData();
		mydata.setRecord(record);
		///////////////////////////////////////////////////////////////////////////////////////////////////�˴������˳����Ʋ������ݸ�gamedata
		if(whetherOut2)
		{
			gameActivity.updateTableCard(utilsFun.List2int(mydata.getCurrentCards()),2);
		}
		else
		{
			gameActivity.updateTableCard(new int[] {-1},2);
		}
		gameActivity.setPCnum();
			

		whetherWin();// �ж���Ӯ
		Log.v("play", "3");
		
		Log.v("play", "4");
		
		if (record == 3) 					//������������˶���Ҫ
		{
			currentcards.clear();
			record = 0;
			transData();
			mydata.setRecord(record);
		}
		
		//// �������һ�غ�

	}

	// �ж���Ӯ
	public void whetherWin() {
		for (int i = 0; i < 3; i++) {
			if (com[i].getCards().size() == 0) {
				// System.out.println("computer"+i+" win!");
				mydata.addScore(-100);
				mydata.setIfWin(1);
			}
		}
	}

	// ��ʼ���ƺ���
	public void CardInit() {

		// ��ʼ����
		int count = 0;
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 13; j++) {
				if (i == 1) {
					card.add(MyTools.getCardByID(count));
					count++;

				} else if (i == 2) {
					card.add(MyTools.getCardByID(count));
					count++;
				} else if (i == 3) {
					card.add(MyTools.getCardByID(count));
					count++;
				} else if (i == 4) {
					card.add(MyTools.getCardByID(count));
					count++;
				}
			}
		}
	}

	// ϴ�Ʋ�����
	public void ShuffleCard() {

		// ϴ��
		for (int i = 0; i < 100; i++) {
			Random random = new Random();
			int a = random.nextInt(52); 
			int b = random.nextInt(52); 
			Card k = card.get(a);
			card.set(a, card.get(b));
			card.set(b, k);
		}

		// ��ʼ����

		int t = 0;
		for (int i = 0; i < 52; i++) 
		{
			switch ((t++) % 4) {
			case 0:
				// ����0
				com[0].addCard(card.get(i));
				break;
			case 1:
				// ����1
				com[1].addCard(card.get(i));
				break;
			case 2:
				// ����2
				com[2].addCard(card.get(i));
				break;
			case 3:
				// ���
				mycards.add(card.get(i));
			}
		}

		// ���������򣬴Ӵ�С
		for (int i = 0; i < 3; i++) {
			MyTools.order(com[i].getCards());
		}
		MyTools.order(mycards);
	}


}
