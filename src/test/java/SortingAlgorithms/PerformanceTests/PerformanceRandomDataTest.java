package SortingAlgorithms.PerformanceTests;

import static SortingAlgorithms.PerformanceTests.DataGenerator.generateRandomNums;

public class PerformanceRandomDataTest extends PerformanceTest {
    @Override
    protected double[] generateNums(int size) {
        return generateRandomNums(size);
    }
}
