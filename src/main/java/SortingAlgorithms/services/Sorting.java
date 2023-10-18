package SortingAlgorithms.services;

import java.util.Objects;

public interface Sorting {
    void sort(double[] v);
    default void validateParams(double[] nums) {
        if(Objects.isNull(nums)) {
            if (nums == null) {
                throw new IllegalArgumentException("Input args (nums) cannot be null!");
            }
        }
    }
    default void swap(double[] data, int firstId, int secondId) {
        if (firstId != secondId) {
            double firstValue = data[firstId];
            data[firstId] = data[secondId];
            data[secondId] = firstValue;
        }
    }
    default boolean isSorted(double[] data) {
        for(int i=0; i<data.length - 1; i++) {
            if(data[i] > data[i+1]) {
                return false;
            }
        }
        return true;
    }
}
