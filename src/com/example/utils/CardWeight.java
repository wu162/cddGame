package com.example.utils;

public class CardWeight {
	
	public final static int 
	None=0,
	Three=3,
    Four=4,
    Five=5,
    Six=6,
    Seven=7,
    Eight=8,
    Nine=9,
    Ten=10,
    Jack=11,
    Queen=12,
    King=13,
    One=14,
    Two=15;
	
	private int weight;
	
	public CardWeight(int w){
		weight = w;
	}
	
	public void setWeight(int w){
		weight = w;
	}
	
	public int getWeight(){
		return weight;
	}
}
