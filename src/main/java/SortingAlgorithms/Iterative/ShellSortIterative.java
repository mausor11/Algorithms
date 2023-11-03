package SortingAlgorithms.Iterative;

import SortingAlgorithms.services.Sorting;

public class ShellSortIterative implements Sorting {
    @Override
    public void sort(double[] nums) {
        validateParams(nums);

        shellSort(nums);
    }
    private void shellSort(double[] nums) {
        int arraySize = nums.length;

        for(int gap = arraySize/2; gap > 0; gap /= 2) {
            int secondId = gap;
            while(secondId < arraySize) {
                int firstId = secondId - gap;
                while(firstId >= 0 && nums[firstId] >= nums[firstId + gap]) {
                    swap(nums, firstId, firstId + gap);
                    firstId-= gap;
                }
                secondId += gap;
            }
        }
    }
}
