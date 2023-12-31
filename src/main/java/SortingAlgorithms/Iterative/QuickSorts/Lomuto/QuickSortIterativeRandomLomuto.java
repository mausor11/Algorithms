package SortingAlgorithms.Iterative.QuickSorts.Lomuto;


import SortingAlgorithms.services.Sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuickSortIterativeRandomLomuto implements Sorting {

    @Override
    public void sort(double[] nums) {
        validateParams(nums);

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
        double pivot = data[randomPivot(data, start, end)];

        int a = start - 1;
        int b = start;

        while (b < end) {
            if (data[b] <= pivot) {
                a++;
                swap(data, a, b);
            }
            b++;
        }
        swap(data, a + 1, end);
        return a + 1;
    }

    private int randomPivot(double[] data, int start, int end) {
        Random random = new Random();
        int pivot = random.nextInt(end - start + 1) + start;
        swap(data, pivot, end);

        return end;
    }


}
