package SearchingAlgorithms;

import SearchingAlgorithms.services.Searching;

public class SequentialSearch implements Searching {
    /**
     * This method takes a {@code double} and sequentially searches int the give table {@code double[]}
     * @param v
     *          Sorted table
     * @param toFind
     *          Value to find
     * @return table index if found, -1 otherwise
     */
    @Override
    public int search(double[] v, double toFind) {
        for(int i = 0; i < v.length; i++) {
            if(v[i] == toFind) {
                return i;
            }
        }
        return -1;
    }
}
