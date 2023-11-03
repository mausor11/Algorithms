package SortingAlgorithms.PerformanceTests;

import static java.lang.String.format;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import SortingAlgorithms.Iterative.QuickSorts.Hoare.QuickSortIterativeHoare;
import SortingAlgorithms.Iterative.QuickSorts.Lomuto.QuickSortIterativeLomuto;
import SortingAlgorithms.services.Sorting;
import org.junit.Test;

public abstract class PerformanceTest {

    @Test
    public void should_RunPerformanceTest_When_InputData() {
        List<Sorting> sorters = getListOfSorters();
        int[] dataSizes = getDataSize();

        measureAndPrintAvgTimeOfAllSorters(sorters, dataSizes);
    }

    protected abstract double[] generateNums(int size);

    private List<Sorting> getListOfSorters() {
        List<Sorting> sorters = new ArrayList<>();

        sorters.add(new QuickSortIterativeHoare());
        sorters.add(new QuickSortIterativeLomuto());

        return sorters;
    }

    private int[] getDataSize() {
        int n = 9;
        int startPower = 11;
        int[] dataSizes = new int[n];

        for (int i = 0; i < n; i++) {
            dataSizes[i] = (int) (Math.pow(2, (startPower + i)));
        }

        return dataSizes;
    }

    private void measureAndPrintAvgTimeOfAllSorters(List<Sorting> sorters, int[] dataSizes) {
        int n = dataSizes.length;

        for (Sorting sorter : sorters) {
            for (int size : dataSizes) {

                double[] dataToSort = generateNums(size);

                measureTimeAndPrintResultsOfSorting(sorter, dataToSort);
            }
        }
    }

    private void measureTimeAndPrintResultsOfSorting(Sorting sorter, double[] dataToSort) {
        String sorterName = getSorterName(sorter);
        int size = dataToSort.length;

        double avgTimeResult = measureAvgTimeOfSorting(sorter, dataToSort);

        System.out.println(format("%20s | %4d | %g", sorterName, size, avgTimeResult));
    }

    private String getSorterName(Sorting sorter) {
        String result = sorter.getClass().getSimpleName();

        return result;
    }

    private long measureAvgTimeOfSorting(Sorting sorter, double[] dataToSort) {
        long[] timeResults = measureTimeInLoop(sorter, dataToSort);

        long avgTime = countAvgWithoutTenOutliers(timeResults);

        return avgTime;
    }

    private long[] measureTimeInLoop(Sorting sorter, double[] orgDataToSort) {
        int nOfRepeat = 100;
        long[] timeResults = new long[nOfRepeat];

        int n = orgDataToSort.length;
        double[] dataToSort = new double[n];

        long currentResult;

        for (int i = 0; i < nOfRepeat; i++) {
            copyData(orgDataToSort, dataToSort);

            currentResult = measureTimeOfSingleSorting(sorter, dataToSort);
            timeResults[i] = currentResult;
        }

        return timeResults;
    }

    private void copyData(double[] src, double[] dest) {
        int n = dest.length;

        for (int i = 0; i < n; i++) {
            dest[i] = src[i];
        }
    }

    private long measureTimeOfSingleSorting(Sorting sorter, double[] dataToSort) {
        long start = System.nanoTime();

        sorter.sort(dataToSort);

        long result = System.nanoTime() - start;

        return result;
    }

    private long countAvgWithoutTenOutliers(long[] timeResults) {
        Arrays.sort(timeResults);

        int nOfOutliers = 10;

        int nOfResults = timeResults.length;
        int start = nOfOutliers;
        int end = nOfResults - nOfOutliers;

        int n = nOfResults - 2 * nOfOutliers;

        assert start < end;

        long avgResult = 0;

        for (int i = start; i < end; i++) {
            avgResult += timeResults[i];
        }

        avgResult /= n;

        return avgResult;
    }

}
