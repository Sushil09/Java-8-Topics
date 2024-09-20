package com.sjsushil09.coreJava.multithreading.MonitorLocks;

public class MonitorLock {
    public static void main(String[] args) {
        MonitorLockTest monitorLockTest = new MonitorLockTest();
        MonitorLockTest monitorLockTest2 = new MonitorLockTest();

        Thread t1 = new Thread(monitorLockTest);
        Thread t2 = new Thread(monitorLockTest);
        Thread t3 = new Thread(monitorLockTest);
        Thread t4 = new Thread(monitorLockTest2);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}

class MonitorLockTest implements Runnable{
    private int val =10;

    public void testMonitorLockWithoutSynchronized() throws InterruptedException {
        Thread.sleep(5000);
        val++;
        System.out.println("The value of val is"+ val+ "by thread"+ Thread.currentThread().getName());
    }

    public synchronized void testMonitorLockWithSynchronized() throws InterruptedException {
        Thread.sleep(5000);
        val++;
        System.out.println("The value of val is"+ val+ "by thread"+ Thread.currentThread().getName());
    }

    @Override
    public void run() {
        try {
            testMonitorLockWithSynchronized();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
