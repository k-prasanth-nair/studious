package com.dp.template;

/**
 * Created by prasanth on 12/3/16.
 */
public class DevelopCSCode extends Develop {
    @Override
    public void keyInCode() {
        System.out.println("code C#");
    }

    @Override
    public void compileCode() {
        System.out.println("run csc");
    }

    @Override
    public void testCode() {
        System.out.println("run nunit");
    }
}
