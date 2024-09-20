package com.sjsushil09.coreJava.multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class ReEntrantLock {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();

        TestReEntrantLock reEntrantLock = new TestReEntrantLock();

        Thread t1 = new Thread(() -> {
            reEntrantLock.testReEntrantLock(reentrantLock);
        });

        Thread t2 = new Thread(() -> {
            reEntrantLock.testReEntrantLock(reentrantLock);
        });

        t1.start();
        t2.start();
    }
}

class TestReEntrantLock {
    public void testReEntrantLock(ReentrantLock reentrantLock) {
        try {
            reentrantLock.lock();
            System.out.println("Lock is held by this thread:" + Thread.currentThread().getName());
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            reentrantLock.unlock();
        }
    }
}
