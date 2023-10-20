package SortingAlgorithms.Iterative;

import SortingAlgorithms.services.Sorting;

public class SelectionSortIterative implements Sorting {
    @Override
    public void sort(double[] nums) {
        validateParams(nums);

        selectionsort(nums);
    }
    private void selectionsort(double[] nums) {
        int arraySize = nums.length;
        int minValID;
        for (int i = 0; i < arraySize; i++) {
            minValID = i;

            for (int j = i; j < arraySize; j++) {
                if (nums[j] < nums[minValID]) {
                    minValID = j;
                }
            }
            swap(nums, i, minValID);
        }
    }
}
