package scaler.dsa.coredsabymanikya.day1problemsolvingintro;

public class NumberOfFactorsOfN {
    //Given a positive Number N (+ve), find the Number of Factors
    public static void main(String[] args) {
        int N = 6453992;
        //Calling a method with brute force approach (Approach - 1)
        //int noOffactors = countNoOfFactorsBruteForce(N);
        //System.out.println(noOffactors);

        //calling method with Optimized approach (Approach - 2)
        int noOfFactors = countNoOfFactors(N);
        System.out.println(noOfFactors);
    }

    //Approach - 2
    public static int countNoOfFactors(int N) {
        int counter = 0;
        for(int i = 1; i <= Math.sqrt(N); i++) {
            if(N % i == 0) {
                if(i == (N/i)) {
                    counter++;
                }else {
                    counter = counter + 2;
                }
            }
        }
        return counter;
    }

    //Approach - 1
    public static int countNoOfFactorsBruteForce(int N) {
        int counter = 0;
        for(int i = 1; i <= N; i++) {
            if(N % i == 0) {
                counter++;
            }
        }
        return counter;
    }
}
