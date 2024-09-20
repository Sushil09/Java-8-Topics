package com.sjsushil09.coreJava.multithreading.producerConsumer;

public class Main {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource(5);

        Thread producer = new Thread(()->{
            resource.produceItem();
        });

        Thread consumer = new Thread(()->{
            resource.consumeItem();
        });

        producer.start();
        consumer.start();
    }
}
