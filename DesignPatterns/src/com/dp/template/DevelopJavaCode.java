package com.dp.template;

/**
 * Created by prasanth on 12/3/16.
 */
public class DevelopJavaCode extends Develop {


    @Override
    public void keyInCode() {
        System.out.println("code Java");
    }

    @Override
    public void compileCode() {
        System.out.println("run javac");
    }

    @Override
    public void testCode() {
        System.out.println("run junit");
    }
}
