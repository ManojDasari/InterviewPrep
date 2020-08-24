package hackerrankSmartInterviews;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrailingZerosEasy {

    public static void main(String[] args) throws IOException {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine().trim());
        for (int i = 0; i < testCases; i++) {
            long n = Long.parseLong(bufferedReader.readLine().trim());
            printTrailingZeros(n);
            System.out.println("");
        }
    }

    public static void printTrailingZeros(long n) {
        long count = 0;
        for (long i = 5; n / i >= 1; i *= 5)
            count += n / i;
        System.out.print(count);
    }

}