package com.BasicJava;

import java.util.List;

public class ArrayList {

	public static void main(String[] args) {
		List<Object> array1=new java.util.ArrayList<>();
		array1.add("selenium");
		array1.add("10");
		array1.add("12.123");
		for(int i=0;i<=array1.size()-1;i++)
		{
			System.out.println("The Object Array is:"+array1.get(i));	
		}
	}

}
