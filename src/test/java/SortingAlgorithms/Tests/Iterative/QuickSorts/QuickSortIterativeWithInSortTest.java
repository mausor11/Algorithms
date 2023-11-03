package SortingAlgorithms.Tests.Iterative.QuickSorts;

import SortingAlgorithms.Iterative.QuickSorts.Lomuto.QuickSortIterativeWithInSortLomuto;
import SortingAlgorithms.utils.GeneralSortTest;

public class QuickSortIterativeWithInSortTest extends GeneralSortTest {
    public QuickSortIterativeWithInSortTest() {
        super(new QuickSortIterativeWithInSortLomuto());
    }
}
