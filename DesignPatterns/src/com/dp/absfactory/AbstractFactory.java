package com.dp.absfactory;

/**
 * Created by prasanth on 12/3/16.
 */

/**
 *
 * Creational Pattern
 *
 * Abstract out object creation. You dont need to know about other classes which we need to use
 *
 * Open Closed principle and Lisk substitution principle
 *
 * Abstract instantiation process
 *
 * Make system independent of how its objects are created composed and represented
 *
 * Encapsulates knowl abt which concrete classes system uses
 *
 * Hides how instances of these classes are created and put together
 *
 *
 *
 * Abstract Factory
 *
 * Provides an interface for creating families of related or dependent objects without specifying their conc classes
 *
 */

public class AbstractFactory {


    public static void main(String[] args) throws ClassNotFoundException,InstantiationException{

        ComputerA com1 = new ComputerA();
        createComputer( com1 , new ComputerFactoryA());
        System.out.println( com1 ) ;


        ComputerB com2 = new ComputerB();
        createComputer( com2 , new ComputerFactoryB());
        System.out.println( com2 ) ;
    }

    // Vilotaes DRY principle
    //private static void createComputerA(Computer A){}
    //private static void createComputerB(Computer A){}


    //Violates open closed principle // If we need one more type of computer we need to come and change the code


    private static void createComputer1(Computer comp){

        if(comp instanceof  ComputerA){
            comp.add(new CPUA());
            comp.add(new MemoryA());
        }else{
            comp.add(new CPUB());
            comp.add(new MemoryB());
        }
    }


    // Computer assembler gets an order with tray which contains all the necessary part

    // if computer is A, then Factory will get all depene parts

    private static void createComputer(Computer comp,ComputerFactory factory){

        comp.add(factory.getCPU());
        comp.add(factory.getMemory());
    }


    //Using reflection to tackle instance creation , so that we dont need to pass Factory
    private static void createComputer(Computer comp) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        String partsType = comp.getPartsType();
        comp.add( (CPU) Class.forName("com.dp.absfactory.CPU"+partsType).newInstance() );
        comp.add( (Memory) Class.forName("com.dp.absfactory.Memory"+partsType).newInstance() );

    }

}
