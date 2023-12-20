package pl.edu.pw.ee.aisd2023zlab6.matrixchainorder;

import java.util.Random;

public class MatrixChainPerformanceTest {

    public static void main(String[] args) {
        //MatrixChainOrderRecursive matrixChainOrder = new MatrixChainOrderRecursive();
        MatrixChainOrderBottomUp matrixChainOrder = new MatrixChainOrderBottomUp();
        Random random = new Random();

        for (int size = 2; size <= 100_000; size += 100) {
            int[] matrixSizes = new int[size];
            for (int i = 0; i < size; i++) {
                matrixSizes[i] = random.nextInt(20) + 1;
            }

            long startTime = System.nanoTime();

            matrixChainOrder.findOptimalOrderCost(matrixSizes);

            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000000;

            System.out.println("Rozmiar tablicy " + size + ", Czas wykonania = " + duration + " ms");
        }
    }
}