package scaler.dsa.sorting;

public class QuickSort {
    public static void main(String[] args) {
        //int[] arr = {6, 2, 9, 10, 13, 15, 5, 3, 8};
        //int[] arr = {1, 2, 4, 6, 11, 11, 9, 13, 14, 18, 21};
        int[] arr = {4, 5, 6, 1, 2, 1, 3};
        int N = arr.length;
        printArray(arr);
        System.out.println();
        quickSortAlgo(arr, 0, N-1);

    }
    public static void quickSortAlgo(int[] arr, int low, int high) {
        if(low < high) {
            int pivot_index = partition(arr, low, high);
            quickSortAlgo(arr, low, pivot_index - 1);
            quickSortAlgo(arr, pivot_index + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low -1;
        for(int j = low; j < high; j++) {
            if(arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;
        printArray(arr);
        System.out.println();
        return i;
    }

    public static void printArray(int[] arr) {
        int N = arr.length;
        //print
        for(int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
