package com.java.threads;

import java.util.concurrent.Semaphore;

/**
 * Created by prasanth on 20/3/16.
 */
public class ProducerConsumerSemaphore {


    public static void main(String[] args) {
        ProducerConsumerSemaphore pc = new ProducerConsumerSemaphore();

        ProducerConsumerSemaphore.ProcuctQueue pq =  pc.new ProcuctQueue();
        ProducerConsumerSemaphore.Producer p = pc.new Producer(pq);
        ProducerConsumerSemaphore.Consumer c= pc.new Consumer(pq);
    }

    class Producer extends Thread{

        ProcuctQueue q;

        public Producer(ProcuctQueue q){
            this.q=q;
            this.setName("Producer Thread");
            this.start();
        }

        public void run(){
            for(int i=0;i<5;i++){
                q.putProductIntoQ(i);
            }

        }

    }

        class Consumer extends Thread{

            ProcuctQueue q;

            public Consumer(ProcuctQueue q){
                this.q=q;
                this.setName("Consumer Thread");
                this.start();
            }

        public void run(){
            for(int i=0;i<5;i++){
                q.getProductFromQ();
            }

        }

    }

    class ProcuctQueue {
        // We must start with Producer semaphore
         Semaphore semProd = new Semaphore(1);
        // Start with consumer semaphore unavailable.
         Semaphore semCon = new Semaphore(0);

        int productId;

        public void putProductIntoQ(int productId){
            try {
                semProd.acquire();
                this.productId=productId;
                System.out.println(Thread.currentThread().getName()+" Putting(In Q) Product ID:"+productId);
                semCon.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void getProductFromQ(){
            try {
                semCon.acquire();
                System.out.println(Thread.currentThread().getName()+" Getting(From Q) Product ID:"+productId);
                semProd.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
