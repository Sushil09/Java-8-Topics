package com.sjsushil09.coreJava.multithreading.producerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {
    Queue<Integer> queue;
    int bufferSize;

    public SharedResource(int bufferSize) {
        queue = new LinkedList<>();
        this.bufferSize = bufferSize;
    }

    public synchronized void produceItem() {
        while (queue.size() == bufferSize) {
            System.out.println("Queue is full, waiting for consumer to consume and Item!");
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
                throw new RuntimeException(ex);
            }
        }
        queue.add(0);
        System.out.println("Notifying consumer to please consume item, current szie of buffer is "+ bufferSize);
        notify();
    }

    public synchronized void consumeItem() {
        while (queue.size()==0){
            System.out.println("Queue is empty, waiting for producer to produce an item!");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                throw new RuntimeException(e);
            }
        }
        queue.poll();
        bufferSize--;
        System.out.println("Notifying producer that consumer had consumed the item");
        notify();
    }
}
