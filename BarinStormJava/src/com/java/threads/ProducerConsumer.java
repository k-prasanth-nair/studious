package com.java.threads;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by prasanth on 20/3/16.
 */
public class ProducerConsumer {



    public  static void main(String s[]){


        List<Integer> sharedQueue = new LinkedList<Integer>(); //Creating shared object
        ProducerConsumer pc = new ProducerConsumer();

        ProducerConsumer.Producer producer= pc.new Producer(sharedQueue,2);
        ProducerConsumer.Consumer consumer= pc.new Consumer(sharedQueue,2);

        Thread producerThread = new Thread(producer, "ProducerThread");
        Thread consumerThread = new Thread(consumer, "ConsumerThread");
        producerThread.start();
        consumerThread.start();
    }





    class Producer implements Runnable{

        private List<Integer> _sharedQueue;

        private int _maxSize;


        public Producer(List<Integer> sharedQueue,int maxSize){

            this._sharedQueue = sharedQueue;
            this._maxSize = maxSize;
        }



        @Override
        public void run() {

            for(int i=0;i<10;i++){
                try {
                    produce(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }


        public void produce(int i) throws InterruptedException {
            System.out.println(_sharedQueue);

            synchronized (_sharedQueue ){
                if( _sharedQueue.size() == _maxSize ){
                    System.out.println("Queue is full, Going to wait state _sharedQueue size = "+_maxSize   );
                    _sharedQueue.wait();
                }
            }

            synchronized (_sharedQueue) {
                System.out.println("Produced : " + i);
                _sharedQueue.add(i);
                Thread.sleep( 1000 );
                _sharedQueue.notify();
            }
        }

    }

    class Consumer implements Runnable{

        private List<Integer> _sharedQueue;

        private int _maxSize;


        public Consumer(List<Integer> sharedQueue,int maxSize){

            this._sharedQueue = sharedQueue;
            this._maxSize = maxSize;
        }



        @Override
        public void run() {

            while(true){
                try {
                    consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }


        public void consume() throws InterruptedException {

            System.out.println(_sharedQueue.toString());

            synchronized (_sharedQueue ){
                if( _sharedQueue.size() == 0 ){
                    System.out.println("Queue is empty, Going to wait state _sharedQueue size = "+_maxSize   );
                    _sharedQueue.wait();
                }

            }

            synchronized (_sharedQueue) {
                System.out.println("Consumed : " + _sharedQueue.remove(0));
                Thread.sleep( 1000 );
                _sharedQueue.notify();
            }
        }

    }
}
