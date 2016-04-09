package com.apptus;

/**
 * Created by prasanth on 5/4/16.
 */
public class Test2 extends Thread {
    MyClass m2;
    public Test2(MyClass mc){
        m2 = mc;
    }

    public void run(){
        m2.m2();
    }
}
