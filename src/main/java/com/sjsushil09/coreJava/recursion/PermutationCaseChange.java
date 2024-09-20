package com.sjsushil09.coreJava.recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationCaseChange {
    public static void main(String[] args) {
        String ip ="abc";
        String op ="";
        List<String> ans = new ArrayList<>();
        solve(ip,op,ans);
        ans.forEach(System.out::println);
    }

    private static void solve(String ip, String op, List<String> ans) {
        if (ip.length()==0) {
            ans.add(op);
            return;
        }

        String op1 = op;
        String op2 = op;

        op1+=ip.substring(0,1);
        op2+=ip.substring(0,1).toUpperCase();
        solve(ip.substring(1),op1,ans);
        solve(ip.substring(1),op2,ans);
    }
}
