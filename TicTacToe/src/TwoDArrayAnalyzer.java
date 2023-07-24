import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class TwoDArrayAnalyzer {
    private int[][] matrix;
    private int N;
    private Map<Integer, Integer>[] rows;
    private Map<Integer, Integer>[] cols;
    private Map<Integer, Integer> diagonals;
    private Map<Integer, Integer> antiDiagonals;
    public Map<Integer, Integer> arrayMap2d;

    public TwoDArrayAnalyzer(int N) {
        this.N = N;
        matrix = new int[N][N];
        rows = new HashMap[N];
        cols = new HashMap[N];
        diagonals = new HashMap<>();
        antiDiagonals = new HashMap<>();
        arrayMap2d = new HashMap<>();
        for (int i = 0; i < N; i++) {
            rows[i] = new HashMap<>();
            cols[i] = new HashMap<>();
        }
    }

    public boolean checkConditions(int row, int col) {
        int element = matrix[row][col];

        // Update row hashmap
        rows[row].put(element, rows[row].getOrDefault(element, 0) + 1);
        System.out.println("HashMap of a Row: " + row);
        TwoDArrayAnalyzer.printHashMaps(rows[row]);
        if (element != 0 && rows[row].get(element) == N) return true;

        // Update column hashmap
        cols[col].put(element, cols[col].getOrDefault(element, 0) + 1);
        System.out.println("HashMap of a Column: " + col);
        TwoDArrayAnalyzer.printHashMaps(cols[col]);
        if (element != 0 && cols[col].get(element) == N) return true;

        // Update diagonal hashmap if the element is on the diagonal
        if (row == col) {
            diagonals.put(element, diagonals.getOrDefault(element, 0) + 1);
            System.out.println("HashMap of a Diagonal: ");
            TwoDArrayAnalyzer.printHashMaps(diagonals);
            if (element != 0 && diagonals.get(element) == N) return true;
        }

        // Update anti-diagonal hashmap if the element is on the anti-diagonal
        if (row + col == N - 1) {
            antiDiagonals.put(element, antiDiagonals.getOrDefault(element, 0) + 1);
            System.out.println("HashMap of Anti Diagonal : ");
            TwoDArrayAnalyzer.printHashMaps(antiDiagonals);
            if (element != 0 && antiDiagonals.get(element) == N) return true;
        }

        return false;
    }

    public static void printHashMaps(Map<Integer, Integer> map){
        // Print all keys and their corresponding values
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            System.out.print(" -> ");
            System.out.println("Key: " + key + ", Value: " + value);
        }
    }

    public void displayArray() {
        System.out.println("Current 2D array:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the 2D array (N): ");
        int N = scanner.nextInt();
        TwoDArrayAnalyzer analyzer = new TwoDArrayAnalyzer(N);

        while (true) {
            System.out.print("Enter row (0 to N-1) or -1 to exit: ");
            int row = scanner.nextInt();
            if (row == -1) break;

            System.out.print("Enter column (0 to N-1) or -1 to exit: ");
            int col = scanner.nextInt();
            if (col == -1) break;

            System.out.print("Enter the value for the 2D array: ");
            int value = scanner.nextInt();

            //analyzer.matrix[row][col] = value;
            if(analyzer.matrix[row][col] == 0) {
                analyzer.matrix[row][col] = value;
                analyzer.arrayMap2d.put(value, analyzer.arrayMap2d.getOrDefault(value, 0) + 1);
                System.out.println("Array elements of 2D ArrayMap are: ");
                TwoDArrayAnalyzer.printHashMaps(analyzer.arrayMap2d);
            }
            else System.out.println("You can't updated non empty cell, try at another position");

            analyzer.displayArray();

            boolean result = analyzer.checkConditions(row, col);
            System.out.println("<<<<<<<---------------->>>>>>>");
            if (result) {
                analyzer.displayArray();
                System.out.println("Conditions met for the 2D array!");
                break;
            }
        }

        scanner.close();
    }
}
