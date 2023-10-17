package pl.edu.pw.ee.aisd2023zlab1.performanceTest;

import static pl.edu.pw.ee.aisd2023zlab1.performanceTest.DataGenerator.generateAscNums;
import static pl.edu.pw.ee.aisd2023zlab1.performanceTest.DataGenerator.generateRandomNums;

public class PerformanceAscDataTest extends PerformanceTest{

    @Override
    protected double[] generateNums(int size) {
        return generateAscNums(size);
    }
}
