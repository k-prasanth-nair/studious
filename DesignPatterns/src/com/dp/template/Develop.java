package com.dp.template;

/**
 * Created by prasanth on 12/3/16.
 */
abstract class Develop{

    public void code(){
        keyInCode();
        compileCode();
        testCode();
    }

    public abstract void keyInCode();
    public abstract void compileCode();
    public abstract void testCode();

}
