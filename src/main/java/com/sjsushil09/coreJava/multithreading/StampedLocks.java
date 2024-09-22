package com.sjsushil09.coreJava.multithreading;

import java.util.concurrent.locks.StampedLock;


/*
Stamp locks provide optimistic & pessimistic locking
optimistic: No locks is acquired as such, on the basis of version numbers.
pessimistic: All locks studied till now, like shared, exclusive, etc.
 */
public class StampedLocks {
    public static void main(String[] args) {

        Resource1 resource1 = new Resource1();

//        Read Locks using Stamp locks
//        Thread t1 = new Thread(resource1::consumeItem);
//        Thread t2 = new Thread(resource1::consumeItem);
//
//        t1.start();
//        t2.start();


//        Write locks using Stamp locks
        Thread t1 = new Thread(resource1::produceItem);
        Thread t2 = new Thread(resource1::produceItem);

        t1.start();
        t2.start();
    }
}

class Resource1 {

    StampedLock lock = new StampedLock();

    //ReadLocks using StampedLocks
    public void consumeItem() {
        long readVersion = lock.readLock(); // provides version number explicitly
       try {
           System.out.println("Thread is acquired by "+ Thread.currentThread().getName());
           try {
               Thread.sleep(5000);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       }finally {
           lock.unlock(readVersion);

       }
    }

    //WriteLocks using StampedLocks
    public void produceItem() {
        long readVersion = lock.writeLock();
        try {
            System.out.println("Thread is acquired by "+ Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }finally {
            lock.unlock(readVersion);

        }
    }
}
