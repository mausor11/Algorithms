package SortingAlgorithms;

import SortingAlgorithms.services.Sorting;

public class MergeSort implements Sorting {
    @Override
    public void sort(double[] nums) {
        validateParams(nums);

        mergesortrecursive(nums, 0, nums.length-1);
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
    private void mergesortrecursive(double[] A, int start, int end) {
        if(start < end) {
            int mid = start +  ((end-start)/2);
            mergesortrecursive(A, start, mid);
            mergesortrecursive(A, mid +1, end);
            merge(A,start,mid,end);
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



    public static void main(String[] args) {
        double[] v = {4,3,7,1,9,6,5,2,6,-2,3};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(v);
        for(int i=0;i<v.length;i++) {
            System.out.println(v[i]);
        }
    }

}
