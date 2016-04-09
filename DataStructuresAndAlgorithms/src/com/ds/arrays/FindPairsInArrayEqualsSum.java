package com.ds.arrays;

import java.util.Arrays;


//we can also do this by hashtable by looking up sum-x in hashtable. add x in hashtable

public class FindPairsInArrayEqualsSum {

	
	public static void printPairs(int sum,int array[]){
		Arrays.sort(array);
		int first = 0;
		int last = array.length-1;
		
		while(first < last){
			int s = array[first] + array[last];
			if(s==sum){
				System.out.println("("+array[first]+", "+array[last]+")");
				++first;
				--last;
			}else if(s < sum){
				++first;
			}else{
				--last;
			}
			
		}
		
	}
	
	
	public static void main(String[] s) {
		int array[]={0,1,2,3,4,-1};
		FindPairsInArrayEqualsSum.printPairs(3, array);
		
	}

}
