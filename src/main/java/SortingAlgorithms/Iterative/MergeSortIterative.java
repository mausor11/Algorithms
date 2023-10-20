package SortingAlgorithms.Iterative;

import SortingAlgorithms.services.Sorting;

public class MergeSortIterative implements Sorting {
    @Override
    public void sort(double[] nums) {
        validateParams(nums);

        mergesort(nums);
    }
    private void mergesort(double[] A) {
        for(int sub_size = 1; sub_size < A.length; sub_size *= 2) {
            for(int left = 0; left < A.length; left += 2*sub_size) {
                int mid = Math.min(left + sub_size - 1, A.length -1);
                int right = Math.min(left + (2*sub_size)-1, A.length-1);
                merge(A,left,mid,right);
            }
        }
    }
    private void merge(double[] A, int start, int mid, int end) {
        int Lsize = mid - start + 1;                                //size of left array
        int Rsize = end - mid;                                      //size of right array

        double[] L = new double[Lsize];                         //Lsize
        double[] R = new double[Rsize];                         //Rsize

        for(int i = 0; i < Lsize; i++) {
            L[i] = A[start + i];
        }
        for(int j = 0; j < Rsize; j++) {
            R[j] = A[mid + j + 1];
        }
        int lIndex = 0;
        int rIndex = 0;
        int begin = start;

        while (lIndex < Lsize && rIndex < Rsize) {

            if (L[lIndex] <= R[rIndex]) {

                A[begin] = L[lIndex];

                lIndex++;

            } else {

                A[begin] = R[rIndex];

                rIndex++;

            }

            begin++;

        }

        while (lIndex < Lsize) {

            A[begin] = L[lIndex];

            lIndex++;

            begin++;

        }

        while (rIndex < Rsize) {

            A[begin] = R[rIndex];

            rIndex++;

            begin++;

        }

    }

}
