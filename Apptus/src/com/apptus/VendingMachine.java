package com.apptus;

import java.util.*;

/**
 * Created by prasanth on 31/3/16.
 */
public class VendingMachine implements IVendingMachine{

    private HashMap<Integer,Product> oProductList = new HashMap<Integer,Product>();

    private CoinChange oChangesAvailable = new CoinChange();

    private Order order;

    @Override
    public void listProducts() {
        for(Map.Entry<Integer,Product>  entry: oProductList.entrySet()){
            System.out.println( entry.getValue() );
        }
    }

    @Override
    public void addProduct(Product p) {
        oProductList.put(p.getProductCode(),p);
    }

    @Override
    public void replenishCoinChange(Coin c) {
        oChangesAvailable.add(c);
    }

    @Override
    public void selectProduct( int code , int qty ){
        if(order == null){
            order = getOrder();
        }
        order.addProduct(code,qty);
    }

    @Override
    public void provideCash(String coin){
        order.provideAmount(coin);
    }

    @Override
    public void finalizeSelection(){
        order.finalizeOrder();
    }

    public void processOrder(){
        try{
            processOrder(order);
            System.out.printf(" Please collect ur items :) ");
        }catch(Exception e){
            System.out.println( e );
        }
        finally {
            order = null;
        }

    }

    private ArrayList<CoinValue> returnChange(ArrayList<CoinValue> oVal) {
        System.out.println( oVal );
        return oVal;
    }



    private boolean processOrder(Order o)throws Exception{
        int total = o.getTotalAmount();
        List<CoinValue> c = o.coins;
        int customerProvidedAmount = VendingUtil.getTotalCoinValue(c);
        assert(customerProvidedAmount >= total);
        if( total == customerProvidedAmount){
            return true;
        }else{
            int change = customerProvidedAmount - total;
            HashMap<Coin,Integer> oCoins = oChangesAvailable.getCoinsForChange(change);
            if(oCoins.isEmpty()){
                throw new Exception("Cannot process the order due to insufficient change; Please try by giving the exact amount");
            }else{
                ArrayList<CoinValue> oVal = new ArrayList<CoinValue>();
                for(Map.Entry<Coin,Integer> coin : oCoins.entrySet()) {
                    coin.getKey().updateCount( coin.getValue() );
                    oVal.add( coin.getKey().getCoinValue());
                }
                returnChange( oVal );
                return true;
            }
        }
    }


    private Order getOrder(){
        return new Order();
    }


    private class Order {

        private ArrayList<OrderDetails> orderList;

        private List<CoinValue> coins = new ArrayList<CoinValue>();

        public Order(){
            this.orderList = new ArrayList<OrderDetails>();
        }

        public void addProduct(int productCode,int qty){
            Product p =  oProductList.get(productCode);
            if(p.getQuantity() < qty){
                throw new IllegalArgumentException("Provide a quantity less than or equal to "+p.getQuantity());
            }
            this.orderList.add(new OrderDetails( oProductList.get(productCode),qty ) );
        }

        public void finalizeOrder(){
            System.out.println("Please provide the total amount "+getTotalAmount());
        }

        public void provideAmount(String coin){
            try {
                coins.add(CoinValue.valueOf(coin));
            }catch(IllegalArgumentException e){
                throw new IllegalArgumentException("This coin is not accepted");
            }
        }

        public int getTotalAmount(){
            int sum = 0;
            for(OrderDetails od:orderList){
                sum += od.getAmount();
            }
            return sum;
        }


        public class OrderDetails {

            private Product p;

            private int qty;

            public OrderDetails(Product p,int qty){
                this.p = p;
                this.qty = qty;
            }

            public int getAmount(){
                return p.getPrice() * qty;
            }
        }

    }



}
