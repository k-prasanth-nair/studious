package com.ds.strings;

/**
 * Created by prasanth on 26/3/16.
 */
public class StringReversal {

    public static void main(String[] args) {

       System.out.println( reverse("helloworld") );

    }


    static String reverse(String s){

        if(s.length() == 1) return s;

        return reverse(s.substring(1)) + s.charAt(0);
    }



}
