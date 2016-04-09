package com.ds.strings;

/**
 * Created by prasanth on 26/3/16.
 */
public class RemoveSpaces {
    public static void main(String[] args) {

        removeSpaces("p r a s a    nth  ");

    }

    public static void removeSpaces(String s){

        int count=0;

        StringBuilder newString = new StringBuilder(s);
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i) != ' '){
                newString.setCharAt(count++,s.charAt(i));

            }
        }

        System.out.println( newString.toString().substring(0,count) );

    }

}
