package com.sjsushil09.coreJava.methodReference;

public class DoStuffImpl {

    public static void doStuff() {
        System.out.println("Hey, this is from inbuilt one!");
        System.out.println("Done");
    }

    public static void RunnableDemo(){
        for(int i=0;i<200;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i);
        }
    }
}
