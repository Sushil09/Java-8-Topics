package com.sjsushil09.coreJava;

import java.util.HashMap;
import java.util.Map;

public class InvestmentAccountOptimizer {

    static class ClientInvestmentOption {
        String name;
        double expectedReturn;
        double risk;

        ClientInvestmentOption(String name, double expectedReturn, double risk) {
            this.name = name;
            this.expectedReturn = expectedReturn;
            this.risk = risk;
        }
    }

    static class ClientInvestmentResult {
        double expectedReturn;
        Map<String, Integer> allocation;

        ClientInvestmentResult(double expectedReturn, Map<String, Integer> allocation) {
            this.expectedReturn = expectedReturn;
            this.allocation = allocation;
        }
    }

    public static ClientInvestmentResult optimizeInvestment(ClientInvestmentOption[] options, int totalInvestment) {
        int n = options.length;
        double[][] dp = new double[n + 1][totalInvestment + 1];

        for (int i = 1; i <= n; i++) { // Fixed loop increment
            for (int j = 0; j <= totalInvestment; j++) { // Start from 0 to handle all investment amounts
                if (i == 1 || j == 0) {
                    dp[i][j] = 0; // Initialize for clarity/boundary conditions
                } else {
                    double currentExpectedReturn = options[i - 1].expectedReturn;
                    double currentRisk = options[i - 1].risk;
                    double currentInvestment = j;

                    if (currentInvestment >= currentRisk) {
                        dp[i][j] = Math.max(dp[i - 1][j], currentExpectedReturn + dp[i - 1][(int) (j - currentRisk)]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }

        Map<String, Integer> allocation = new HashMap<>();
        int remainingInvestment = totalInvestment;
        for (int i = n; i > 0; i--) {
            double currentExpectedReturn = options[i - 1].expectedReturn; // Corrected incomplete statement
            double currentRisk = options[i - 1].risk;

            if (remainingInvestment > 0 && dp[i][remainingInvestment] != dp[i - 1][remainingInvestment]) {
                int allocatedAmount = (int) (remainingInvestment / currentRisk);
                allocation.put(options[i - 1].name, allocatedAmount);
                remainingInvestment -= allocatedAmount * currentRisk;
            }
        }

        return new ClientInvestmentResult(dp[n][totalInvestment], allocation);
    }

    public static void main(String[] args) {
        ClientInvestmentOption[] options = {
                new ClientInvestmentOption("Stocks", 0.18, 0.25),
                new ClientInvestmentOption("Equity", 0.25, 0.13),
                new ClientInvestmentOption("Real Estate", 0.27, 0.36)
        };

        int totalInvestment = 20000; // Fixed missing type

        ClientInvestmentResult result = optimizeInvestment(options, totalInvestment); // Corrected variable assignment

        System.out.println("Optimal Expected Return: " + result.expectedReturn);
        System.out.println("Optimal Allocation:");
//        for (Map.Entry<String, Integer> entry : result.al
    }
}