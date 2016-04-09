package com.ds.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {

	public static void main(String[] args) {


		String s = "hi   prasanth";

		String str[] = s.split("\\s+");

		for(String s1:str){

			System.out.println(s1);
		}
	
	}


	static String[] missingWords(String s,String t){
		String str[] = s.split("\\s+");



		ArrayList<String> missingList = new ArrayList<String>();

		String susequentArray[] = s.split("\\t+");
		ArrayList<String> subList= new ArrayList<String>(Arrays.asList(susequentArray));

		for(String main:str){
			if(!subList.contains(main)){
				missingList.add(main);
			}
		}

		String[] arr = missingList.toArray(new String[missingList.size()]);

		return arr;


	}
	
	public void a(){
		
	}
	
    public void A(){
		
	}

}
