package com.dp.strategy;

/**
 * Created by prasanth on 12/3/16.
 */


/**
 * Overcomes the disadvantage of the Tenplate Method pattern
 *
 * Here client is aware of the steps and also it decides what strategy needs to be used for. *
 *
 * Prevents class Proliferation; Vary implementation, client knows about the strategy. Let client choose
 *
 * Open closed principle.No new classes.reuse
 *
 * Dependency Inversion. Develop depends on Build and Test abstraction
 *
 *
 *  Collections.sort() and Comparator interface are examples
 *
 */
public class StrategyPattern {

    public static void work(Develop develop){
        develop.code();
    }

    public static void main(String[] args) {
        work(new Develop(new MavenBuild(),new TestWithJunit()));
        work(new Develop(new GradleBuild(),new TestWithTestNG()));
    }

}

//Strategy Interface
interface Build{
    public void runBuild();
}

//Strategy Interface
interface Test{
    public void runTest();
}

class Develop{

    Build build;
    Test test;

    public void code(){
        keyInCode();
        build.runBuild();
        test.runTest();
    }

    //Using strategy Interfaces

    public Develop(Build theBuild,Test theTest){

        build = theBuild;
        test = theTest;
    }

    public void keyInCode(){
        System.out.println(" Code with java");
    }

}

class MavenBuild implements Build{

    public void runBuild(){
        System.out.println( " Run with maven" );
    }
}

class GradleBuild implements Build{

    public void runBuild(){
        System.out.println( " Run with gradle" );
    }
}

class TestWithJunit implements Test{

    public void runTest(){
        System.out.println( " Test with Junit" );
    }
}

class TestWithTestNG implements Test{

    public void runTest(){
        System.out.println( " Test with TestNG" );
    }
}


