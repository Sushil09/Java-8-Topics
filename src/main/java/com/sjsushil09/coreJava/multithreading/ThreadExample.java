package com.sjsushil09.coreJava.multithreading;

public class ThreadExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                if (i % 2 == 0) {
                    System.out.println(i+"Even");
                    try {
                        Thread.sleep(1000*i);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                if (i % 2 != 0) {
                    System.out.println(i+"Odd");
                    try {
                        Thread.sleep(1000*i);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }
}
