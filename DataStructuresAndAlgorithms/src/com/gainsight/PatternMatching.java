package com.gainsight;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by prasanth on 29/3/16.
 */
public class PatternMatching {

    private long nextNum = 0;
    private long seriesLength = 0;
    private long fourCount = 0;

    public PatternMatching(int input){
        int length = String.valueOf(input).length();
        seriesLength = length - 1;
        fourCount = seriesLength;
    }

    public long next(){
       if( seriesLength == fourCount ){
           nextNum = get4Series();
           fourCount = 1;
           seriesLength = seriesLength +1;
       }else{
           nextNum = nextNum + 4 * getFactor( (seriesLength -fourCount) ) ;
           fourCount ++;
       }
        return nextNum;
    }

    public long getFactor(long length){
        return Long.parseLong(String.format("%-" + length + "s", "1").replace(' ', '0'));
    }

    public long get4Series(){
        return 4 * Long.parseLong(String.format("%-" + (seriesLength + 1) + "s", "1").replace(' ', '0'));
    }

    public long getA(){
        return fourCount;
    }


    public long getB(){
        return seriesLength - fourCount;
    }


    public static long computeExpression(long a,long b){
        return 2*a+b;
    }


   public static HashMap<Character,Integer> getCount(int num){

      String s =  String.valueOf(num);

      HashMap<Character,Integer> oMap = new HashMap<Character, Integer>();

      for(int i=0;i<s.length();i++){
          char c = s.charAt(i);
          if(oMap.containsKey(c)){
              oMap.put(c,oMap.get(c)+1);
          }else{
              oMap.put(c,1);
          }
      }

      return oMap;

   }



    public static void main(String s[]){

     ArrayList<Integer> oList = new ArrayList<Integer>();
        oList.add(2);
        oList.add(4);
        oList.add(5);
        oList.add(80);
        oList.add(34);
        oList.add(110);
        oList.add(11000);

     for(Integer input:oList){
         PatternMatching oM = new PatternMatching(input);
         long number = 0;
         try {

             while (true) {
                 number = oM.next();
                 if (number % input == 0) {
                     break;
                 }
             }
             System.out.println( computeExpression(oM.getA(),oM.getB()));

         }catch(Exception e){
                System.out.println(e);
         }



     }

  System.out.println("44440000 "+getCount(44440000).get('4'));
  System.out.println("444400 "+getCount(444400).get('0'));

    }


}
