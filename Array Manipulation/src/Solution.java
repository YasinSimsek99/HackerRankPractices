import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long max = 0;
        long[] resultArray = new long[n + 1];
        long[] tempArray = new long[n];
       

        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int a = q[0];
            int b = q[1];
            int k = q[2];
            addK(resultArray, a - 1, b - 1, k);
        }

        for (int i = 0; i < tempArray.length; i++) {

            if (i == 0)
                tempArray[i] = resultArray[i];
            else {
                tempArray[i] = resultArray[i] + tempArray[i - 1];
                if (tempArray[i] > max)
                    max = tempArray[i];
            }
        }
        return max;
    }

    static void addK(long array[], int a, int b, int k) {
        array[a] += k;
        array[b + 1] -= k;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
