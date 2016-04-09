package com.ds.strings;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Created by prasanth on 17/3/16.
 */
public class BiggestPaliandrome {


    private ArrayList<String> oList = new ArrayList<String>();

    public String biggestPaliandrome(String str){

        if( PaliandromeChecker.isPaliandrome(str) ) return str;
        else{
            findBiggest( str );
             if(oList.isEmpty())
                 throw new NoSuchElementException("");
             else
               return oList.get(0);
        }

    }

    private void findBiggest(String str){

        if(str ==null || str.isEmpty()) return;

        if( str.length() ==  1) return;

        if( PaliandromeChecker.isPaliandrome(str) ){
            if(oList.isEmpty()){
                oList.add(str);
            }else{
                if(oList.get(0).length() < str.length()){
                    oList.add(0,str);
                }
            }

        }

        for(int i=1;i<str.length()-1;i++){
          findBiggest( str.substring( i ) );
        }

        for(int j=str.length()-1;j>=0;j--){
            findBiggest( str.substring( 0,j ) );
        }

    }

    public static void main(String s[]){

        BiggestPaliandrome oBig = new BiggestPaliandrome();

        System.out.println( oBig.biggestPaliandrome("MMALAYALAMS") );

    }


}
