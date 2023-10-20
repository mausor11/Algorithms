package SortingAlgorithms.Recursive;

import SortingAlgorithms.services.Sorting;

public class InsertionSortRecursive implements Sorting {
    @Override
    public void sort(double[] nums) {
        validateParams(nums);

        insertionSort(nums, nums.length);
    }
    private void insertionSort(double[] nums, int n) {
        if(n <= 1) {
            return;
        }
        insertionSort(nums, n-1);

        double key = nums[n-1];
        int j = n-2;
        while(j >= 0 && nums[j] > key) {
            nums[j+1] = nums[j];
            j--;
        }
        nums[j+1] = key;
    }
}
