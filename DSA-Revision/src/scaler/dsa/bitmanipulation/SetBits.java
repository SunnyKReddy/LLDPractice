package scaler.dsa.bitmanipulation;

public class SetBits {
    public static void main(String[] args) {
        //System.out.println(1&1);
        int N = 15;
        //System.out.println(N<<2);
        //System.out.println(N>>2);
        System.out.println(countSetBitsRightShift(N));
        System.out.println(countSetBitsLeftShift(N));
    }

    public static int countSetBitsRightShift(int N) {
        int counter = 0;
        while(N > 0) {
            int bit = N & 1;
            if(bit == 1) {
                counter++;
            }
            N = N>>1;
        }
        return counter;
    }

    public static int countSetBitsLeftShift(int N) {
        int counter = 0;
        int temp = 1;
        while (temp <= N) {
            int bit = temp & N;
            if(bit > 0) {
                counter++;
            }
            temp = temp << 1;
        }
        return counter;
    }
}
