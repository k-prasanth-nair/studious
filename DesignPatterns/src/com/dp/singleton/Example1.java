package com.dp.singleton;

/**
 * Created by prasanth on 12/3/16.
 */
public class Example1 {



    public static Singleton getInstance(){
        return Singleton.INSTANCE;
    }


    // To enure the same object while deserialization
    private Object readResolve(){
        return Singleton.INSTANCE;
    }

    // thread safe

    //To lazy load a class. While class loading the java will ensure no two objects get created
    public static class Singleton{
        public static final Singleton INSTANCE = new Singleton();
    }
}
