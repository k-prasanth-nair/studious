package com.apptus;

import java.util.Scanner;

/**
 * Created by prasanth on 1/4/16.
 */
public class VendingMachineMain {

    public static void main(String s[]){

        VendingMachine vm = new VendingMachine();
        vm.addProduct(new Product(1,"Pepsi",2,12));
        vm.addProduct(new Product(2,"Aquafina",10,20));
        vm.addProduct(new Product(3,"DairyMilk",2,25));
        vm.addProduct(new Product(4,"Cake",2,10));

        vm.listProducts();

        vm.replenishCoinChange(new Coin(CoinValue.FIVE_HUNDRED, 0));
        vm.replenishCoinChange(new Coin(CoinValue.HUNDRED, 2));
        vm.replenishCoinChange(new Coin(CoinValue.FIFTY, 1));
        vm.replenishCoinChange(new Coin(CoinValue.TEN, 2));
        vm.replenishCoinChange(new Coin(CoinValue.FIVE, 1));
        vm.replenishCoinChange(new Coin(CoinValue.TWO, 1));

        System.out.println("Please select number of products");

        Scanner scan = new Scanner(System.in);

        try{

           int n =  scan.nextInt();

           for(int i=0;i<n;i++){

               System.out.println("Enter product code ");
               int code =  scan.nextInt();
               System.out.println("Enter quantity ");
               int qty = 0;
               try{
                   qty = scan.nextInt();
               }catch(Exception e){
                   System.out.println(e);
               }
               vm.selectProduct(code,qty);

           }
           vm.finalizeSelection();
           System.out.println("Provide only coins of 500,100,50,10,5,2,1");
           System.out.println("Enter Done after inserting coins");
           while( scan.hasNext() ) {
               String str = scan.next();
               if(! str.equals("Done") ){
                   vm.provideCash( VendingUtil.getCoinValue( Integer.parseInt( str ) ) );
               }else
                    break;
           }
          vm.processOrder();


        }finally{
            scan.close();
        }
    }
}
