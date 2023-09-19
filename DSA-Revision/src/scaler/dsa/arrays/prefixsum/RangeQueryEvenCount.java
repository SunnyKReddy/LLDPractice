package scaler.dsa.arrays.prefixsum;

public class RangeQueryEvenCount {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 8, 9, 6, 9, 10, 4};
        int[][] queries = {{4,8}, {3,7}, {1,3}, {0,4}};
        int arr_length = arr.length;
        //given array {2, 3, 4, 7, 8, 9, 6, 9, 10, 4}
        //creating prefix sum array, if arr[i] is even then increment count with 1 else don't increment count
        // prefix_sum array for even numbers count = {1, 1, 2, 2, 3, 3, 4, 4, 5, 6}

        int[] prefixsum_array = new int[arr_length];
        if(arr[0] % 2 == 0) {
            prefixsum_array[0] = 1;
        }
        for(int i = 1; i < arr_length; i++) {
            if(arr[i] % 2 == 0) {
                prefixsum_array[i] = prefixsum_array[i - 1] + 1;
            } else {
                prefixsum_array[i] = prefixsum_array[i - 1];
            }
        }
        for(int i = 0; i < queries.length; i++) {
            System.out.println(rangeQueryCountEvenNumbers(prefixsum_array, queries[i][0], queries[i][1]));
        }
    }

    public static int rangeQueryCountEvenNumbers(int[] prefix_sum, int left, int right) {
        if(left == 0) {
            return prefix_sum[right];
        }else {
            return prefix_sum[right] - prefix_sum[left - 1];
        }
    }
}
