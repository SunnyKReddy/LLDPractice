package scaler.dsa.bitmanipulation;

public class FlipBits {
    public static void main(String[] args) {
        int a = 1, b = 9;
        System.out.println(countFlipBits(a, b));
    }
    public static int countFlipBits(int a, int b) {
        int N = a ^ b;
        return countSetBits(N);
    }

    public static int countSetBits(int N) {
        int counter = 0;
        while(N > 0) {
            if((N & 1) > 0) {
                counter++;
            }
            N = N >> 1;
        }
        return counter;
    }
}
