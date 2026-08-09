package com.bank.test;

import java.util.concurrent.*;

public class Test {
    public static final int MAX_NUM = 10;
    static  int num =0;
    static Semaphore s1 = new Semaphore(1);
    static Semaphore s2 = new Semaphore(0);
    public static void printName(int i){
        System.out.println(i+": Thread Name: "+Thread.currentThread().getName());
    }
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
           while(num<MAX_NUM){
               try {
                 //  if(num<MAX_NUM) {
                       s1.acquire();
                       System.out.println("Thread-1 : current value: " + num++);
                       s2.release();
                 //  }
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
        });

        Thread t2 = new Thread(()->{
            while(num<MAX_NUM){
                try {
                  //  if(num<MAX_NUM) {
                        s2.acquire();
                        System.out.println("Thread-2 : current value: " + num++);
                        s1.release();
                  //  }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t2.start();

        ExecutorService executorService= Executors.newFixedThreadPool(10);
        for(int i=0;i<10;i++){
            int finalI = i;
            CompletableFuture.runAsync(()->printName(finalI), executorService);
        }
        executorService.shutdown();


    }
}
