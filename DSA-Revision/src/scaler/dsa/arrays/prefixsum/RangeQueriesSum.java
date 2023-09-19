package scaler.dsa.arrays.prefixsum;

public class RangeQueriesSum {
    // Given an integer array arr[N] and Q queries, each query contains Left, Right indexes.
    // For each query calculate sum of all index elements in arr[N] from Left index to Right index
    // Print Sum.
    public static void main(String[] args) {
        int[] arr = {-3, 6, 2, 4, 5, 2, 8, -9, 3, 1};
        int[][] queries = {{4,8}, {3,7}, {1,3}, {0,4}};
        int array_length = arr.length;
//        for(int i = 0; i < queries.length; i++) {
//            System.out.println(rangeQuerySumBruteForce(arr, queries[i][0], queries[i][1]));
//        }
        int[] prefix_sum_arr = new int[array_length];
        prefix_sum_arr[0] = arr[0];
        for(int i = 1; i < array_length; i++) {
            prefix_sum_arr[i] = prefix_sum_arr[i - 1] + arr[i];
        }
        for(int i = 0; i < queries.length; i++) {
            System.out.println(rangeQuerySumPrefixSum(prefix_sum_arr, queries[i][0], queries[i][1]));
        }
    }
    // Prefix Sum Array O(N + Q)
    public static int rangeQuerySumPrefixSum(int[] prefixsum_arr, int left, int right) {
        if(left == 0) {
            return prefixsum_arr[right];
        }else {
            return prefixsum_arr[right] - prefixsum_arr[left - 1];
        }
    }
    //Brute force approach O(Q * N)
    public static int rangeQuerySumBruteForce(int[] arr, int left, int right) {
        int sum = 0;
        for(int i = left; i <= right; i++) {
            sum = sum + arr[i];
        }
        return sum;
    }

}
