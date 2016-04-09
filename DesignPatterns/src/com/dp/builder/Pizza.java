package com.dp.builder;

import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

/**
 * Created by prasanth on 12/3/16.
 */
public class Pizza {

    private Crust _crust;

    private Sauce _sauce;

    private String _cheese;

    private String[] _toppings;

    public void createCrust(){

        _crust = new Crust();
    }
    public void spreadSauce(){
        _sauce = new Sauce();
    }

    public void addCheese(){

        _cheese = "Amul";
    }

    public void addToppings(String... toppings){
        _toppings = toppings;
    }

    public void bake(){

        System.out.println("Baking.....");
    }

    public String toString(){
       // String toppings = Stream.of(_toppings).collect(joining(","));
        return ""+_crust+":"+_sauce+":"+_cheese+":";
    }


}
