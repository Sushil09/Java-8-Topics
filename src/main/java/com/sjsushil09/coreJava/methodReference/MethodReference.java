package com.sjsushil09.coreJava.methodReference;

public class MethodReference {
    public static void main(String[] args) {
//        WorkInterf workInterf = DoStuffImpl::doStuff;
//        workInterf.doStuff();


        Runnable runnable = DoStuffImpl::RunnableDemo;
        runnable.run();

        Thread t = new Thread(runnable);

            for(int i=0;i<200;i++){
                System.out.println(i+"main");
            }

        t.start();
        }


}
