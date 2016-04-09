package com.java.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by prasanth on 20/3/16.
 */
public class ExecutorTest {

   static  ArrayList<String> images = new ArrayList<String>();

   static  ExecutorService oService = Executors.newFixedThreadPool( 1000 );

    public static void main(String[] args) throws Exception{

        images.add( "image1" );
        images.add( "image2" );
        images.add( "image3" );
        images.add( "image4" );
        images.add( "image5" );


        List<Future<String>> oFutures= new ArrayList<Future<String>>();

        for(final String image:images){

            oFutures.add( oService.submit( new Callable<String>() {

                @Override
                public String call() throws Exception {

                    if( image == "image3"){
                        Thread.sleep(1000);
                    }

                    return " Downloaded "+image;
                }


            }) );


        }


        for(Future<String> future:oFutures){

            //Executor Service will get results in the submitted order
            System.out.println( future.get() );
        }

        /**
         * OUTPUT
         *
         *  Downloaded image1
            Downloaded image2
            Downloaded image3
            Downloaded image4
            Downloaded image5
         *
         */

    }
}
