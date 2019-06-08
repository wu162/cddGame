package com.example.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameData {
	public ArrayList<Boolean> cardSelected;
	
	public List<Integer> currentcards;
	public List<Integer> mycards;
	public List<Integer> com0cards;
	public List<Integer> com1cards;
	public List<Integer> com2cards;
	
	public int score;
	public int record;
	public int ifWin;
	public boolean PASS;
	
	public boolean conti;

	public GameData() {
		cardSelected=new ArrayList<Boolean>();
		
		currentcards=new ArrayList();
		mycards=new ArrayList();
		com0cards=new ArrayList();
		com1cards=new ArrayList();
		com2cards=new ArrayList();
		score=0;
		record=0;
		ifWin=0;
		PASS=false;
		conti=false;
	}
	
	public boolean getConti() {
		return conti;
	}

	public void setConti(boolean conti) {
		this.conti = conti;
	}

	public void setPass(boolean s){
		PASS=s;
	}
	
	public boolean getPass(){
		return PASS;
	}
	
	public void setIfWin(int i){
		ifWin=i;
	}
	
	public int getIfWin(){
		return ifWin;
	}
	
	public int getRecord(){
		return record;
	}
	
	public void setRecord(int r){
		record=r;
	}
	
	public void addScore(int s){
		score+=s;
	}

	public ArrayList<Boolean> getCardSelected() {
		return cardSelected;
	}

	public void setCardSelected(ArrayList<Boolean> cardSelected) {
		this.cardSelected = cardSelected;
	}

	public List getCurrentCards() {
		return currentcards;
	}

	public void setCurrentCards(List<Integer> card) {
		this.currentcards = card;
	}
	
	public List getMyCards() {
		return mycards;
	}
	
	public int[] getMyCard() {
		int[] mycard=new int[mycards.size()];
		for(int i=0;i<mycards.size();i++)
		{
			mycard[i]=mycards.get(i);
		}
		return mycard;
	}

	public void setMyCards(List<Integer> card) {
		this.mycards = card;
	}
	
	public void setMyCards(int[] card) {
		mycards.clear();
		for(int i=0;i<card.length;i++)
		{
			mycards.add(Integer.valueOf(card[i]));
		}
	}
	
	public List getCom0Cards() {
		return com0cards;
	}

	public void setCom0Cards(List<Integer> card) {
		this.com0cards = card;
	}
	public List getCom1Cards() {
		return com1cards;
	}

	public void setCom1Cards(List<Integer> card) {
		this.com1cards = card;
	}
	public List getCom2Cards() {
		return com2cards;
	}

	public void setCom2Cards(List<Integer> card) {
		this.com2cards = card;
	}
}
