package com.apptus;

import java.util.List;

/**
 * Created by prasanth on 31/3/16.
 */
public class VendingUtil {


    public static boolean validateQuantity(int ordeQ,Product p){

        if(p.isStockAvailable()){
            return ordeQ < p.getQuantity();
        }
        return false;

    }

    public static int getTotalCoinValue(List<CoinValue> coins){
        int sum = 0;
        for(CoinValue c:coins){
            sum += c.getValue();
        }
        return sum;

    }

    public static String getCoinValue(int coin){
        String val = "";
        switch(coin){

            case 500: val = "FIVE_HUNDRED";
                break;
            case 100: val = "HUNDRED";
                break;
            case 50:  val = "FIFTY";
                break;
            case 10:  val = "TEN";
                break;
            case 5:   val = "FIVE";
                break;
            case 2:   val = "TWO";
                break;
            case 1:   val = "ONE";
                break;

        }
        return val;
    }
}
