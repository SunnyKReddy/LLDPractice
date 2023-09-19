package scaler.dsa.coredsabymanikya.day4introductiontoarrays;

public class GreaterThanItself {
    public static void main(String[] args) {
        int[] arr = {2, 3, 10, 7, 3, 2, 10, 8};
        System.out.println(findNumbersGreaterThanItselfCount(arr));
    }

    public static int findNumbersGreaterThanItselfCount(int[] arr) {
        int counter = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
                counter = 1; continue;
            }
            if(arr[i] == max) {
                counter++;
            }
        }
        return arr.length - counter;
    }


}
