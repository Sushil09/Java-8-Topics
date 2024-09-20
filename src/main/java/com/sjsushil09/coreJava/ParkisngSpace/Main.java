package com.sjsushil09.coreJava.ParkisngSpace;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
   
    }

    public static double[][] dataGen(int sampleNumber) {
        double[] x = new double[sampleNumber * 2];
        double[] y = new double[sampleNumber * 2];
        for (int i = 0; i < sampleNumber * 2; i++) {
            x[i] = i % sampleNumber + 1;
            y[i] = 6 + 3 * x[i] + 0.1;
        }
        double[][] data = new double[sampleNumber * 2][2];
        for (int i = 0; i < sampleNumber * 2; i++) {
            data[i][0] = x[i];
            data[i][1] = y[i];
        }
        return data;
    }

    public static double[] findCoef(int numSimulations, int sampleNumber) {
        double[] results = new double[numSimulations];
        Random random = new Random();

        for (int i = 0; i < numSimulations; i++) {
            double[][] data = dataGen(sampleNumber);
            double[] x = new double[sampleNumber * 2];
            double[] y = new double[sampleNumber * 2];
            for (int j = 0; j < sampleNumber * 2; j++) {
                x[j] = data[j][0];
                y[j] = data[j][1];
            }

            // Calculate coefficients
            double sumCoefficients = 0.0;
            double sumX = 0.0;
            double sumY = 0.0;
            double sumXSquared = 0.0;
            double sumXY = 0.0;
            for (int j = 0; j < sampleNumber * 2; j++) {
                sumX += x[j];
                sumY += y[j];
                sumXSquared += x[j] * x[j];
                sumXY += x[j] * y[j];
            }
            double beta1 = (sampleNumber * 2 * sumXY - sumX * sumY) / (sampleNumber * 2 * sumXSquared - sumX * sumX);
            double beta0 = (sumY - beta1 * sumX) / (sampleNumber * 2);

            sumCoefficients = beta0 + beta1;

            results[i] = sumCoefficients;
        }

        return results;
    }
}
