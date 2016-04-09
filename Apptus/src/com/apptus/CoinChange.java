package com.apptus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by prasanth on 31/3/16.
 */
public class CoinChange {


    ArrayList<Coin> coins;

    public CoinChange(){
        coins = new ArrayList<Coin>();
    }

    public void add(Coin c){
        coins.add(c);
    }

    public HashMap<Coin,Integer> getCoinsForChange( int amount ){
        ArrayList<Coin> smallCoins = getAllCoinValulesLessThanAmount(coins,amount);
        return getCoinsForAmount(smallCoins,amount);
    }


    private HashMap<Coin,Integer> getCoinsForAmount( ArrayList<Coin> smallCoins , int amount){
        HashMap<Coin,Integer> change = new HashMap<Coin,Integer>();
        int remAmount = amount;
        for(Coin c:smallCoins){
            int cc = remAmount / c.getValue();
            if(cc > 0){
                if( cc <= c.getCount() ){
                    change.put(c,cc);
                    remAmount = remAmount - cc * c.getValue();
                }else{
                    change.put(c,c.getCount());
                    remAmount = remAmount - c.getCount() * c.getValue();
                }
            }

        }
        if(remAmount == 0){
            return change;
        }
        return new HashMap<Coin,Integer>();
    }

    private ArrayList<Coin> getAllCoinValulesLessThanAmount(ArrayList<Coin> coins, int amount){
        ArrayList<Coin> smallCoins = new ArrayList<Coin>();
        for(Coin c:coins){
            if( c.getCount() > 0 && amount >= c.getValue() ){
                smallCoins.add(c);
            }
        }
        Collections.sort(smallCoins);
        return smallCoins;
    }


    public static void main(String s[]){

        CoinChange cc = new CoinChange();

        cc.add(new Coin(CoinValue.FIVE_HUNDRED,0));
        cc.add(new Coin(CoinValue.HUNDRED,2));
        cc.add(new Coin(CoinValue.FIFTY,1));
        cc.add(new Coin(CoinValue.TEN,2));
        cc.add(new Coin(CoinValue.FIVE,1));
        cc.add(new Coin(CoinValue.TWO,1));


        System.out.println(cc.getCoinsForChange(277));
    }




}
