package scaler.dsa.arrays.carryforward;

public class CountPairs {
    //Given a  character array ch[] = {a, e, a, g, g, d},
    // find no.of pairs of (a,g) such that i > j & ch[i] == 'a', ch[j] == 'g'
    public static void main(String[] args) {
        //char[] ch = {'a', 'e', 'a', 'g', 'g', 'd'};
        char[] ch = {'a', 'd', 'g', 'a', 'g', 'a', 'g', 'f', 'g'};
        System.out.println("Pairs count: " + CountPairs.countPairs(ch));
    }

    public static int countPairs(char[] ch) { // TC: O(N) SC: O(1)
        int N = ch.length;
        int ans = 0, cg = 0;
        for(int i = N - 1; i >= 0; i--) {
            if(ch[i] == 'g') {
                cg++;
            } else if (ch[i] == 'a') {
                ans = ans + cg;
            }
        }
        return ans;
    }
}
