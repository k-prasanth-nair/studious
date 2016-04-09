package com.apptus;

/**
 * Created by prasanth on 5/4/16.
 */
public class Test extends Thread {

    MyClass m1;
    public Test(MyClass mc){
        m1 = mc;
    }

    public void run(){
        try {
            m1.m1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
