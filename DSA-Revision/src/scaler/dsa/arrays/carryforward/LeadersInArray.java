package scaler.dsa.arrays.carryforward;

public class LeadersInArray {
    // Consider an integer array, an array element is said to be a leader,
    // if arr[i] is greater than all the elements to it's left i.e., [0, i-1]
    // consider arr[0] as leader by default, count total no. of leaders in an array.
    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 5, 2, 7};
        int leaders_count_left = LeadersInArray.countLeadersLeft(arr);
        System.out.println("No. of Leaders in an given array are (Left side Sceneario): " + leaders_count_left);
        int [] arr1 = {10, 7, 9, 3, 2, 4};
        int leaders_count_right = LeadersInArray.countLeadersRight(arr1);
        System.out.println("No. of Leaders in an given array are (Right side Sceneario): " + leaders_count_right);
    }

    public static int countLeadersLeft(int[] arr) { // TC: O(N) SC: O(1)
        int N = arr.length;
        int leadersCount = 1, current_leader = arr[0];
        for(int i = 1; i < N; i++) {
            if(arr[i] > current_leader) {
                leadersCount++;
                current_leader = arr[i];
            }
        }
        return leadersCount;
    }

    public static int countLeadersRight(int[] arr) {  // TC: O(N) SC: O(1)
        int N = arr.length;
        int leadersCount = 1, current_leader = arr[N - 1];
        for(int i = N - 2; i >= 0; i--) {
            if(arr[i] > current_leader) {
                leadersCount++;
                current_leader = arr[i];
            }
        }
        return leadersCount;
    }
}
