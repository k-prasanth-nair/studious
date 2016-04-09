package com.apptus;

/**
 * Created by prasanth on 5/4/16.
 */
public class MyClass {

    public static synchronized void m1() throws InterruptedException {
        System.out.println("Hiiiiiiiiiiiiiii");
        Thread.sleep(3000);
    }

    public static synchronized void m2(){
        System.out.println("m2222222222");
    }
}
