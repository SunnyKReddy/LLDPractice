package scaler.dsa.arrays.subarrays;

public class PrintAllSubArrays {
    //Given an array arr[N], print all the subarrays
    public static void main(String[] args) {
        int[] arr = {4, 1, 5, 3, -1, 14, 9, 8, 12};

        printAllSubArraysofArray(arr);
    }

    public static void printAllSubArraysofArray(int[] arr) {
        int N = arr.length;
        for(int i = 0; i < N; i++) {
            for(int j = i; j < N; j++) {
                for(int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
        }
    }
}
