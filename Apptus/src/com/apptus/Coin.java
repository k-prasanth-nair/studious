package com.apptus;

/**
 * Created by prasanth on 31/3/16.
 */

enum CoinValue {
   FIVE_HUNDRED(500),
   HUNDRED(100),
   FIFTY(50),
   TEN(10),
   FIVE(5),
   TWO(2),
   ONE(1);

   private final int val;
   private CoinValue(int value){
       val = value;
   }
   public int getValue(){
       return val;
   }
   

};

public class Coin implements Comparable<Coin>{

   private CoinValue value;

   private int numOfCoins;

   public Coin(CoinValue value,int count){
       this.value = value;
       this.numOfCoins = count;
   }

   public void updateCount(int count){
       this.numOfCoins = this.numOfCoins - count;
   }

   public int getValue(){

       return this.value.getValue();
   }

   public CoinValue getCoinValue() {
     return this.value;
   }

   public void add(int count){
       this.numOfCoins = count;
   }

    public int getCount(){
        return this.numOfCoins;
    }


    public static void main(String[] args) {
        System.out.println( CoinValue.FIVE_HUNDRED );
    }

    public String toString(){
        return "Coin: "+value.getValue();
    }

    public int compareTo(Coin that){

        if(that == null) return 1;

        return this.getValue() < that.getValue()? 1: this.getValue() > that.getValue() ? -1 :0 ;
    }


}
