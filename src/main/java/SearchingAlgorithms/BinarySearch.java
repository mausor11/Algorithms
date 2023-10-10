package SearchingAlgorithms;

public class BinarySearch implements Searching {
    /**
     * This method takes a {@code double} and binary searches int the give table {@code double[]}
     * @param v
     *          Sorted table
     * @param toFind
     *          Value to find
     * @return table index if found, -1 otherwise
     */
    @Override
    public int search(double[] v, double toFind) {
        int start = 0;
        int end = v.length -1;

        while(start <= end) {
            int mid = start + ((end-start)/2);
            if(v[mid] < toFind) {
                start = mid + 1;
            }
            else if(v[mid] > toFind) {
                end = mid -1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
}
