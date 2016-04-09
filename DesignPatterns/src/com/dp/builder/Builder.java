package com.dp.builder;

/**
 * Created by prasanth on 12/3/16.
 */

/**
 *
 *  Abstract Factory is focuses on preserving families of objects
 *  Builder is focusing on steps needed to create an object
 *
 * In the case of the Abstract Factory, the client uses the factory�s methods to create its own objects.
 * In the Builder�s case, the Builder class is instructed on how to create the object and then it is asked for it,
 * but the way that the class is put together is up to the Builder class, this detail making the difference between the two patterns.
 *
 */
public class Builder {

    public static void main(String[] args) {

        PizzaMaker oMaker = new PizzaMaker();

        PizzaBuilder cheeseBuilder= new CheesePizzaBuilder();
        oMaker.makePizza(cheeseBuilder);

        System.out.println(cheeseBuilder.create());
    }
}
