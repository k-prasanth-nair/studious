package com.dp.builder;

/**
 * Created by prasanth on 12/3/16.
 */
public abstract class PizzaBuilder {

    private Pizza pizza = new Pizza();

    protected Pizza getPizza(){
        return pizza;
    }

    public abstract void createCrust();
    public abstract void spreadSauce();
    public abstract void addCheese();
    public abstract void addToppings();
    public abstract void bake();

    public Pizza create(){ return pizza;}


}
