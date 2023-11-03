package SortingAlgorithms.PerformanceTests;


import static SortingAlgorithms.PerformanceTests.DataGenerator.generateAscNums;

public class PerformanceAscDataTest extends PerformanceTest {
    @Override
    protected double[] generateNums(int size) {
        return generateAscNums(size);
    }
}