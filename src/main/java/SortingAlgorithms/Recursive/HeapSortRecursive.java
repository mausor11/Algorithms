package SortingAlgorithms.Recursive;

import SortingAlgorithms.services.Sorting;

public class HeapSortRecursive implements Sorting {
    @Override
    public void sort(double[] v) {
        validateParams(v);

        heapsort(v);
    }
    private void build_max_heap(double[] A, int heap_size) {
        for(int i = heap_size / 2 - 1; i >= 0; i--) {
            max_heapify(A, heap_size, i);
        }

    }

    private void max_heapify(double[] A, int heap_size, int i) {
        int largest = i;
        int left_child = 2*i + 1;
        int right_child = 2*i + 2;

        if(left_child < heap_size && A[left_child] > A[largest]) {
            largest = left_child;
        }
        if(right_child < heap_size && A[right_child] > A[largest]) {
            largest = right_child;
        }
        if(largest != i) {
            swap(A, i, largest);
            max_heapify(A, heap_size, largest);
        }
    }
    private void heapsort(double[] A) {
        int heap_size = A.length;
        build_max_heap(A, heap_size);
        for(int i = heap_size -1; i > 0; i--) {
            swap(A, 0, i);
            max_heapify(A, i, 0 );
        }
    }


}
