package com.dp.builder;

/**
 * Created by prasanth on 12/3/16.
 */
public class CheesePizzaBuilder extends PizzaBuilder {


    @Override
    public void createCrust() {
        getPizza().createCrust();
    }

    @Override
    public void spreadSauce() {
        getPizza().spreadSauce();
    }

    @Override
    public void addCheese() {
        getPizza().addCheese();
    }

    @Override
    public void addToppings() {
        getPizza().addToppings("cheese");
    }

    @Override
    public void bake() {
        getPizza().bake();
    }
}
