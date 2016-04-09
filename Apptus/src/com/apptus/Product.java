package com.apptus;

/**
 * Created by prasanth on 31/3/16.
 */
public class Product implements IProduct {

    private int productCode;
    private String name;
    private int quantity;
    private int price;
    private static final String NEWLINE = System.getProperty("line.separator");

    public Product(int code,String name,int qty,int price){
        this.name = name;
        this.productCode = code;
        this.quantity = qty;
        this.price = price;
    }

    @Override
    public boolean isStockAvailable(){
        return quantity > 0;
    }

    @Override
    public void replenishStock(int qty){
        this.quantity = qty;
    }

    @Override
    public int getPrice(){
        return this.price;
    }

    public int getProductCode(){
        return productCode;
    }

    public int getQuantity(){

        return quantity;
    }

    public String toString(){

        StringBuilder sb = new StringBuilder();
        sb.append("Product Code:").append(productCode);
        sb.append(NEWLINE);
        sb.append("Product Name:").append(name);
        sb.append(NEWLINE);
        sb.append("Price:").append(name);
        sb.append(NEWLINE);
        sb.append("Quantity:").append(quantity);
        sb.append(NEWLINE);
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {

        if(obj == this) return true;

        if(!(obj instanceof Product) ){
            return false;
        }

        Product p =  (Product)obj;
        return this.productCode == p.productCode;

    }

    @Override
    public int hashCode() {
        return this.productCode * 17;
    }
}