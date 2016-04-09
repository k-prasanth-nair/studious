package com.ds.strings;

import java.util.ArrayList;

/**
 * Created by prasanth on 17/3/16.
 */
public class PaliandromeChecker {

    static boolean isPaliandrome(String str){

        System.out.println(str);

        if(str.length() == 1){
            return true;
        }else{
            int begin = 0;
            int end = str.length()-1;
            int mid = (begin+end)/2;
            int i ;
            for( i=begin;i<=mid;i++ ){

               if( str.charAt(begin) == str.charAt(end) )
                {
                    begin++;
                    end--;

                }else
                    break;
            }

            if( i > mid ){
                return true;
            }else{
                return false;
            }
        }




    }


    public static void main(String s[]){

        System.out.println(isPaliandrome("MALAYALAM"));
        System.out.println(isPaliandrome("APPLE"));

        System.out.println("hii".substring(0,2));

    }


}
