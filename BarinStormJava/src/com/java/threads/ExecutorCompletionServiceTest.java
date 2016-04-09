package com.java.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by prasanth on 20/3/16.
 */
public class ExecutorCompletionServiceTest {

    static ArrayList<String> images = new ArrayList<String>();

    static ExecutorService oService = Executors.newFixedThreadPool(1000);

    static ExecutorCompletionService oCompService = new ExecutorCompletionService<String>(oService);

    public static void main(String[] args) throws Exception{

        images.add( "image1" );
        images.add( "image2" );
        images.add( "image3" );
        images.add( "image4" );
        images.add( "image5" );


        List<Future<String>> oFutures= new ArrayList<Future<String>>();

        for(final String image:images){

            oFutures.add( oCompService.submit( new Callable<String>() {

                @Override
                public String call() throws Exception {

                    if( image == "image3"){
                        Thread.sleep(1000);
                    }

                    return " Downloaded "+image;
                }


            }) );


        }


        for(int i=0;i<oFutures.size();i++){

            //Executor Service will get results in the processed order
            System.out.println( oCompService.take().get() );
        }

        /**
         * OUTPUT
         *
         *  Downloaded image1
         Downloaded image2
         Downloaded image4
         Downloaded image5
         Downloaded image3
         *
         */

    }
}
