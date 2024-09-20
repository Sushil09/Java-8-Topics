package com.sjsushil09.coreJava.multithreading;

public class SynchronizedBlock {
    public static void main(String[] args) {
        Test test1 = new Test();
        Test test2 = new Test();

        Thread t1 = new Thread(test1::task1);
        Thread t2 = new Thread(test2::task1);

        t1.start();
        t2.start();
    }
}

class Test extends Thread{

    public synchronized void task1(){
        try {
            System.out.println("Task 1");
            Thread.sleep(10000);
            System.out.println("Task 1 completed");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void task2(){
        synchronized (this){
            System.out.println("Task 2");
        }
    }

    public void task3(){
        System.out.println("Without Monitor lock, in task3");
    }
}