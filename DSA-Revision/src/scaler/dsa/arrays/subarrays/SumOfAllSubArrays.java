package scaler.dsa.arrays.subarrays;

public class SumOfAllSubArrays {
    public static void main(String[] args) {
        int[] arr = {4, 1, 5, 3, -1, 14, 9, 8, 12};
        //int[] arr = {1, 5, -7, 9};
        //int[] arr = {3, 2, 4, 5};
        //sumOfAllSubArraysOfArrayBruteForce(arr);

        int arr_length = arr.length;
        int[] prefix_sum = new int[arr_length];
        prefix_sum[0] = arr[0];
        for(int i = 1; i < arr_length; i++) {
            prefix_sum[i] = prefix_sum[i - 1] + arr[i];
        }

        //sumOfAllSubArraysPrefixSum(prefix_sum);
        sumOfAllSubArraysCarryForward(arr);
        maxSumOfAllSubArrays(arr);
        //evenSubArraySums(arr);
        evenSumSubArrayEqualsTo(arr, 5);
    }

    //No.of even length subarrays with sum equal to given value
    public static void evenSumSubArrayEqualsTo(int[] arr, int value) {
        int N = arr.length;
        int total_evensum_subarrays = 0;
        for(int i = 0; i < N; i++) {
            int sum = 0;
            for(int j = i; j < N; j++) {
                sum = sum + arr[j];
                if (sum >= value && ((j - i) % 2) != 0) {
                    total_evensum_subarrays++;
                    System.out.println(sum);
                }

            }
        }
        System.out.println("Even length sub-arrays that are greater than given value: " + total_evensum_subarrays);
    }
    //even sum subarrays count
    public static void evenSubArraySums(int[] arr) {
        int N = arr.length;
        int total_evensum_subarrays = 0;
        for(int i = 0; i < N; i++) {
            int sum = 0;
            for(int j = i; j < N; j++) {
                sum = sum + arr[j];
                if (sum % 2 == 0) {
                    total_evensum_subarrays++;
                    System.out.println(sum);
                }

            }
        }
        System.out.println("Even Sum sub-arrays are: " + total_evensum_subarrays);
    }
    public static void maxSumOfAllSubArrays(int[] arr) {
        int N = arr.length;
        int start = 0, end = 0;
        int max_sum = Integer.MIN_VALUE;
        int total_sum = 0;
        for(int i = 0; i < N; i++) {
            int sum = 0;
            for(int j = i; j < N; j++) {
                sum = sum + arr[j];
                if(sum > max_sum) {
                    start = i; end = j;
                    max_sum = sum;
                }
                total_sum = total_sum + sum;
                //System.out.println(sum);
            }
        }
        System.out.println("Max sum sub array Start index: '" + start + "', End index: '" + end + "'");
        System.out.println("Max sum of a sub array in given array is:  " + max_sum);
    }

    //TC: O(N^2) SC: O(1)
    public static void sumOfAllSubArraysCarryForward(int[] arr) {
        int N = arr.length;
        int total_sum = 0;
        for(int i = 0; i < N; i++) {
            int sum = 0;
            for(int j = i; j < N; j++) {
                sum = sum + arr[j];
                total_sum = total_sum + sum;
                System.out.println(sum);
            }
        }
        System.out.println("Total sub-array sum: " + total_sum);
    }

    //TC: O(N^2 + N) SC: O(N)
    public static void sumOfAllSubArraysPrefixSum(int[] arr) {
        int N = arr.length;
        int total_sum = 0;
        for(int start = 0; start < N; start++) {
            int sum = 0;
            for(int end = start; end < N; end++) {
                if(start == 0) {
                    sum = arr[end];
                }else {
                    sum = arr[end] - arr[start - 1];
                }
                System.out.println(sum);
                total_sum = total_sum + sum;
            }
        }
        System.out.println(total_sum);
    }



    // TC: O(N^3) & SC: O(1)
    public static void sumOfAllSubArraysOfArrayBruteForce(int[] arr) {
        int N = arr.length;
        for(int i = 0; i < N; i++) {
            for(int j = i; j < N; j++) {
                int sum = 0;
                for(int k = i; k <= j; k++) {
                    sum = sum + arr[k];
                }
                System.out.println(sum);
            }
        }
    }
}
