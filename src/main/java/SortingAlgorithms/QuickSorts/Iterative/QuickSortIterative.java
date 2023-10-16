package SortingAlgorithms.QuickSorts.Iterative;

import SortingAlgorithms.services.Sorting;

import java.util.ArrayList;
import java.util.List;

public class QuickSortIterative implements Sorting {
    /**
     * This method takes a {@code double} table and sorts using "Quick Sort Classic Version"
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
        int left = start + 1;
        int right = end;

        while (left < right) {
            while (left < right && data[left] < data[start]) {
                left++;
            }

            while (left < right && data[right] >= data[start]) {
                right--;
            }

            swap(data, left, right);
        }

        if (data[left] >= data[start]) {
            left--;
        }

        swap(data, start, left);

        return left;
    }

    public void printTab(double[] tab) {
        if (tab != null) {
            System.out.print("[");
            for (int i = 0; i < tab.length - 1; i++) {
                System.out.print(tab[i] + ",");
            }
            System.out.println(tab[tab.length - 1] + "]");
        }
    }
}
