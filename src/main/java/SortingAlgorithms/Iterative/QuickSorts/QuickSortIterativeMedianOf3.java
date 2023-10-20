package SortingAlgorithms.Iterative.QuickSorts;

import SortingAlgorithms.services.Sorting;

import java.util.ArrayList;
import java.util.List;

public class QuickSortIterativeMedianOf3 implements Sorting {
    /**
     * This method takes a {@code double} table and sorts using "Quick Sort Median of Three"
     * @param nums
     *          Unsorted table
     * @throws IllegalArgumentException table is null
     */
    @Override
    public void sort(double[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Input args (nums) cannot be null!");
        }

        quicksort(nums);

    }

    private void quicksort(double[] data) {
        List<Integer> starts = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();
        Integer left = 0;
        Integer right = data.length - 1;
        starts.add(left);
        ends.add(right);
        int n = 1;
        int pivot;
        if (left < right) {

            while (n > 0) {
                n--;
                left = starts.remove(n);
                right = ends.remove(n);
                pivot = splitData(data, left, right);
                if (pivot - 1 > left) {
                    starts.add(left);
                    ends.add(pivot - 1);
                    n++;
                }

                if (pivot + 1 < right) {
                    starts.add(pivot + 1);
                    ends.add(right);
                    n++;
                }
            }
        }
    }

    private int splitData(double[] data, int start, int end) {
        sortFirstMidLastElements(data, start, end);
        int left = start + 1;
        int right = end - 1;
        int pivot = end - 1;
        while (left < right) {
            while (left < right && data[left] < data[pivot]) {
                left++;
            }

            while (left < right && data[right] >= data[pivot]) {
                right--;
            }
            swap(data, left, right);
        }

        swap(data, left, pivot);
        return left;
    }

    private void sortFirstMidLastElements(double[] nums, int start, int end) {
        int mid = start + ((end - start) / 2) + isNextTo(start, end);
        double[] median = new double[]{nums[start], nums[mid], nums[end]};

        for (int i = 1; i < median.length; i++) {
            double key = median[i];
            int j = i - 1;

            while (j >= 0 && median[j] > key) {
                median[j + 1] = median[j];
                j--;
            }
            median[j + 1] = key;
        }
        nums[start] = median[0];
        nums[mid] = median[1];
        nums[end] = median[2];
        swap(nums, mid, end - 1);

    }

    private int isNextTo(int start, int end) {
        if (end - start == 1) {
            return 1;
        }
        return 0;
    }
}
