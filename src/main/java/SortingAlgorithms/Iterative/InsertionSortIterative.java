package SortingAlgorithms.Iterative;

import SortingAlgorithms.services.Sorting;

import java.util.Objects;

public class InsertionSortIterative implements Sorting {
    @Override
    public void sort(double[] nums) {
        validParams(nums);

        insertionSort(nums);

    }

    private void validParams(double[] nums) {
        if (Objects.isNull(nums)) {
            throw new RuntimeException("Input args (nums) cannot be null!");
        }
    }

    private void insertionSort(double[] data) {
        int secondId = 1;
        int arraySize = data.length;

        while (secondId < arraySize) {
            int firstId = secondId - 1;
            while (firstId >= 0 && data[firstId] >= data[firstId + 1]) {
                swap(data, firstId, firstId + 1);
                firstId--;

            }
            secondId++;
        }
    }
}
