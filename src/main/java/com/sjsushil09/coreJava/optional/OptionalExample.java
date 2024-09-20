package com.sjsushil09.coreJava.optional;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        String s1= "david";
        String s2= "david";

        Optional<String> op1 = Optional.ofNullable(s1);
        Optional<String> op2 = Optional.ofNullable(s2);
        //If the value was present, return that value or else give the other value
//        System.out.println(op.orElse("Since the vlaue was null, so this is returned!"));

        System.out.println(op2.equals(op1));
    }
}
