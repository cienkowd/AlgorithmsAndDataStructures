package pl.edu.pw.ee.aisd2023zlab6.matrixchainorder;

import static java.util.Objects.isNull;

public class MatrixChainOrderRecursive {

    public MatrixChainOrderResult findOptimalOrder(int[] matrixSizes) {
        validateInput(matrixSizes);
        int numOfMatrices = matrixSizes.length - 1;

        int[][] costCounters = initCostCounters(numOfMatrices + 1);

        int startIndex = 1;
        int minMultiplyCost = findOptimalOrderCost(costCounters, matrixSizes, startIndex, numOfMatrices);

        MatrixChainOrderResult finalResult = new MatrixChainOrderResult(minMultiplyCost);

        return finalResult;
    }

    private int[][] initCostCounters(int size) {
        int[][] costCounters = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                costCounters[i][j] = Integer.MAX_VALUE;
            }
        }

        return costCounters;
    }

    private int findOptimalOrderCost(int[][] costCounters, int[] matrixSizes, int startId, int endId) {
        int calculationCost, subMatricesCost, currentMultiplyCost;
        int result = 0;

        if (startId == endId) {
            costCounters[startId][endId] = 0;

        } else {

            for (int pivotIndex = startId; pivotIndex < endId; pivotIndex++) {

                subMatricesCost = findOptimalOrderCost(costCounters, matrixSizes, startId, pivotIndex)
                        + findOptimalOrderCost(costCounters, matrixSizes, pivotIndex + 1, endId);

                currentMultiplyCost = matrixSizes[startId - 1] * matrixSizes[pivotIndex] * matrixSizes[endId];
                calculationCost = subMatricesCost + currentMultiplyCost;

                if (calculationCost <= costCounters[startId][endId]) {
                    costCounters[startId][endId] = calculationCost;
                    result = calculationCost;
                }
            }
        }

        return result;
    }

    private void validateInput(int[] matrixSizes) {
        if (isNull(matrixSizes)) {
            throw new IllegalArgumentException("The matrixSizes cannot be null!");
        }

        if (matrixSizes.length < 2) {
            throw new IllegalArgumentException("The matrixSizes must contain at least two values!");
        }
    }

}
