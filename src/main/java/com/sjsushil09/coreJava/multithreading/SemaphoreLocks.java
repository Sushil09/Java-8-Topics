package com.sjsushil09.coreJava.multithreading;

import java.util.concurrent.Semaphore;

public class SemaphoreLocks {
    public static void main(String[] args) {

        Resource2 resource2 = new Resource2();

        Thread t1 = new Thread(resource2::consume);
        Thread t2 = new Thread(resource2::consume);
        Thread t3 = new Thread(resource2::consume);

        t1.start();
        t2.start();
        t3.start();

    }
}

class Resource2 {

    Semaphore lock = new Semaphore(2); // allows only 1 thread to enter critical section

    public void consume() {
        try{
            lock.acquire();
            System.out.println("Semaphore lock is acquired by thread " + Thread.currentThread().getName());
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.release();
        }
    }
}
