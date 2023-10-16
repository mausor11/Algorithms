package SortingAlgorithms.QuickSorts.Iterative;

import SortingAlgorithms.QuickSorts.Iterative.Lomuto.QuickSortIterativeWithInSortLomuto;
import SortingAlgorithms.services.Sorting;
import SortingAlgorithms.utils.GeneralSortTest;

public class QuickSortIterativeWithInSortTest extends GeneralSortTest {
    public QuickSortIterativeWithInSortTest() {
        super(new QuickSortIterativeWithInSortLomuto());
    }
}
