package com.sjsushil09.coreJava.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLocks {
    public static void main(String[] args) {

        Resource resource = new Resource();

//        Using ReadLocks
//        Thread t1 = new Thread(resource::produceItem);
//        Thread t2 = new Thread(resource::produceItem);
//        Thread t3 = new Thread(resource::produceItem);
//
//        t1.start();
//        t2.start();
//        t3.start();

//        Using WriteLocks
        Thread t1 = new Thread(resource::consumeItem);
        Thread t2 = new Thread(resource::consumeItem);
        Thread t3 = new Thread(resource::consumeItem);

        t1.start();
        t2.start();
        t3.start();


    }
}

class Resource {

    ReadWriteLock lock = new ReentrantReadWriteLock();
    public void produceItem()  {
        try{
            lock.readLock().lock();
            System.out.println("Read Lock is acquired by thread "+ Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        finally {
            lock.readLock().unlock();
        }

    }

    public void consumeItem()  {
        try{
            lock.writeLock().lock();
            System.out.println("Write Lock is acquired by thread "+ Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        finally {
            lock.writeLock().unlock();
        }

    }
}
