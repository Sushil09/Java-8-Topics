package com.sjsushil09.coreJava.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReEntrantLock {
    public static void main(String[] args) {
        Lock reentrantLock = new ReentrantLock();

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
    public void testReEntrantLock(Lock lock) {
        try {
            lock.lock(); //acquiring the lock
            System.out.println("Lock is held by this thread:" + Thread.currentThread().getName());
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            lock.unlock(); //releasing the lock
        }
    }
}
