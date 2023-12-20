package pl.edu.pw.ee.aisd2023zlab6.rodcuttingproblem;

import java.util.Random;

public class RodCutterPerformanceTest {

    public static void main(String[] args) {
        //RodCutterBottomUp rodCutter = new RodCutterBottomUp();
        //RodCutterTopDown rodCutter = new RodCutterTopDown();
        RodCutterRecursive rodCutter = new RodCutterRecursive();

        Random rd = new Random();
        int[] prices = new int[1_000_000];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = rd.nextInt();
        }

        for (int rodLength = 0; rodLength <= 1_000_000; rodLength+=1) {
            long startTime = System.nanoTime();

            rodCutter.cutRod(prices, rodLength);

            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000000;

            System.out.println("Rod length " + rodLength + ", Time taken = " + duration + " ms");
        }
    }
}