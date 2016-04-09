package com.ds.strings;

import java.util.HashMap;

/**
 * Created by prasanth on 26/3/16.
 */
public class DuplicatesInString {

    public static void main(String[] args) {

        findDuplicates("hgjhglkbaiioo");

    }

    static void findDuplicates(String s){


        int[] arr = new int[256];

        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)]++;
        }

        for(int i=0;i<256;i++){
            if(arr[i]>1){
                System.out.println( Character.toChars(i) );
            }
        }


    }

    static void findDuplicatesUsingHashMap(String s){


        HashMap<Character,Integer> oMap = new HashMap<Character, Integer>();

        for(int i=0;i<s.length();i++){
            if(oMap.containsKey(s.charAt(i))){
                oMap.put(s.charAt(i),oMap.get( s.charAt(i) )+1);
            }else{
                oMap.put(s.charAt(i),0);
            }
        }

    }

}
