package com.sjsushil09.coreJava.multithreading.methods;

public class TestJoin {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Main thread started " + Thread.currentThread().getName());

        Thread t1 = new Thread(() -> {
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + "is started");
                Thread.sleep(7000);
                System.out.println("Thread " + Thread.currentThread().getName() + "is completed");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();

        //Main thread will wait till t1 is completed.
        t1.join();
        System.out.println("Main Thread completed " + Thread.currentThread().getName());
    }
}


