package com.java.threads;

/**
 * Created by prasanth on 20/3/16.
 */
public class MemoryVisibility implements Runnable {

    private static int number;

    private static boolean isReady;

    @Override
    public void run() {

        while (!isReady) {
            System.out.println(number);
        }
    }


    public static void main(String[] args) throws InterruptedException {

        Thread oth = new Thread( new MemoryVisibility() );
        oth.start();
        Thread.sleep(500);
        number = 100;
        isReady = true;

    }
}
