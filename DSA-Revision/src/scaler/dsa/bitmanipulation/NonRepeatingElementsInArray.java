package scaler.dsa.bitmanipulation;

public class NonRepeatingElementsInArray {
    public static void main(String[] args) {
        int[] arr = {4, 2, 10, 3, 4, 2, 1, 10};
        findNonRepeatingElements(arr);
    }

    public static void findNonRepeatingElements(int[] arr) {
        int N = arr.length;
        int sum = 0;
        for(int i = 0; i < N; i++) {
            sum = sum ^ arr[i];
        }
        //System.out.println(sum);
        //finding right most set bit
        int right_sb = sum & ~(sum - 1);
        //System.out.println(right_sb);
        int unq_num1 = 0, unq_num2 = 0;
        for(int i = 0; i < N; i++) {
            if((right_sb & arr[i]) > 0) {
                unq_num1 = unq_num1 ^ arr[i];
            }else {
                unq_num2 = unq_num2 ^ arr[i];
            }
        }
        System.out.println(unq_num1);
        System.out.println(unq_num2);
    }
}
