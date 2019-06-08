package com.example.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.example.R;
import com.example.activity.implementation.GameActivity;
import com.example.model.GameData;
import com.example.view.GameView;

import android.os.Handler;
import android.util.Log;

public class utilsFun {
	public static int[] getSelected(ArrayList<Boolean> choose,int[] list,Boolean selected)
	{
		ArrayList<Integer> newarray=new ArrayList<Integer>();
		int select=selected?1:0;
		Log.v("cardselected", ""+list.length);
		for(int i=0;i<list.length;i++)
		{
			int tmp=choose.get(i)?1:0;
			if(tmp==select)
			{
				newarray.add(Integer.valueOf(list[i]));
			}
		}
		int[] newlist=new int[newarray.size()];
		for(int i=0;i<newarray.size();i++)
		{
			newlist[i]=newarray.get(i);
		}
		
		return newlist;
	}
	
	public static List<Integer> int2List(int[] arr)
	{
		List<Integer> List=new ArrayList();
		for(int i=0;i<arr.length;i++)
		{
			List.add(Integer.valueOf(arr[i]));
		}
		return List;
	}
	
	public static int[] List2int(List<Integer> List)
	{
		int[] arr=new int[List.size()];
		for(int i=0;i<List.size();i++)
		{
			arr[i]=List.get(i);
		}
		return arr;
	}
	
	public static void initcardSelected(ArrayList<Boolean> cardSelected,int size)
	{
		cardSelected.clear();
		for(int i=0;i<size;i++)
		{
			cardSelected.add(false);
		}
	}
	
	public static int getPlace(int p)
	{
		int place=0;
		switch(p)
		{
		case 0:
			place=R.id.pc0cardshow;
			break;
		case 1:
			place=R.id.pc1cardshow;
			break;
		case 2:
			place=R.id.pc2cardshow;
			break;
		case 3:
			place=R.id.playercardshow;
			break;
		}
		return place;
	}
	
	public static int getPic(int i)
	{
		int src=0;
		switch(i)
		{
		case 0:
			src=R.drawable.squareone;
			break;
		case 1:
			src=R.drawable.squaretwo;
			break;
		case 2:
			src=R.drawable.squarethree;
			break;
		case 3:
			src=R.drawable.squarefour;
			break;
		case 4:
			src=R.drawable.squarefive;
			break;
		case 5:
			src=R.drawable.squaresix;
			break;
		case 6:
			src=R.drawable.squareseven;
			break;
		case 7:
			src=R.drawable.squareeight;
			break;
		case 8:
			src=R.drawable.squarenine;
			break;
		case 9:
			src=R.drawable.squareten;
			break;
		case 10:
			src=R.drawable.squarejack;
			break;
		case 11:
			src=R.drawable.squarequeen;
			break;
		case 12:
			src=R.drawable.squareking;
			break;
		case 13:
			src=R.drawable.clubone;
			break;
		case 14:
			src=R.drawable.clubtwo;
			break;
		case 15:
			src=R.drawable.clubthree;
			break;
		case 16:
			src=R.drawable.clubfour;
			break;
		case 17:
			src=R.drawable.clubfive;
			break;
		case 18:
			src=R.drawable.clubsix;
			break;
		case 19:
			src=R.drawable.clubseven;
			break;
		case 20:
			src=R.drawable.clubeight;
			break;
		case 21:
			src=R.drawable.clubnine;
			break;
		case 22:
			src=R.drawable.clubten;
			break;
		case 23:
			src=R.drawable.clubjack;
			break;
		case 24:
			src=R.drawable.clubqueen;
			break;
		case 25:
			src=R.drawable.clubking;
			break;
		case 26:
			src=R.drawable.heartone;
			break;
		case 27:
			src=R.drawable.hearttwo;
			break;
		case 28:
			src=R.drawable.heartthree;
			break;
		case 29:
			src=R.drawable.heartfour;
			break;
		case 30:
			src=R.drawable.heartfive;
			break;
		case 31:
			src=R.drawable.heartsix;
			break;
		case 32:
			src=R.drawable.heartseven;
			break;
		case 33:
			src=R.drawable.hearteight;
			break;
		case 34:
			src=R.drawable.heartnine;
			break;
		case 35:
			src=R.drawable.heartten;
			break;
		case 36:
			src=R.drawable.heartjack;
			break;
		case 37:
			src=R.drawable.heartqueen;
			break;
		case 38:
			src=R.drawable.heartking;
			break;
		case 39:
			src=R.drawable.spadeone;
			break;
		case 40:
			src=R.drawable.spadetwo;
			break;
		case 41:
			src=R.drawable.spadethree;
			break;
		case 42:
			src=R.drawable.spadefour;
			break;
		case 43:
			src=R.drawable.spadefive;
			break;
		case 44:
			src=R.drawable.spadesix;
			break;
		case 45:
			src=R.drawable.spadeseven;
			break;
		case 46:
			src=R.drawable.spadeeight;
			break;
		case 47:
			src=R.drawable.spadenine;
			break;
		case 48:
			src=R.drawable.spadeten;
			break;
		case 49:
			src=R.drawable.spadejack;
			break;
		case 50:
			src=R.drawable.spadequeen;
			break;
		case 51:
			src=R.drawable.spadeking;
			break;
		}
		
		return src;
	}
}
