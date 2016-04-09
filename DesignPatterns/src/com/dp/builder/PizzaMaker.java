package com.dp.builder;

/**
 * Created by prasanth on 12/3/16.
 */
public class PizzaMaker {

    public void makePizza(PizzaBuilder pizzaBuilder){
        System.out.println("Creating crust");
        pizzaBuilder.createCrust();
        System.out.println("Spreading sauce");
        pizzaBuilder.spreadSauce();
        System.out.println("Adding cheese");
        pizzaBuilder.addCheese();
        System.out.println("Adding toppings");
        pizzaBuilder.addToppings();
        System.out.println("Baking");
        pizzaBuilder.bake();

    }
}
