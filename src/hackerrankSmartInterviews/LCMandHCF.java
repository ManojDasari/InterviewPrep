package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCMandHCF {

    public static void main(String[] args) throws IOException {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine().trim());
        for (int i = 0; i < testCases; i++) {
            String[] input = bufferedReader.readLine().trim().split(" ");
            System.out.println(lcm(Long.parseUnsignedLong(input[0]), Long.parseUnsignedLong(input[1])) + " "
                    + gcd(Long.parseUnsignedLong(input[0]), Long.parseUnsignedLong(input[1])));
        }
    }

    public static long gcd(long a, long b) {
        if (a == 0)
            return b;
        if (b == 0)
            return a;
        if (a == b)
            return a;
        if (a > b)
            return gcd(a%b, b);
        return gcd(a, b%a);
    }

    public static long lcm(long a, long b) {
        long gcdValue = gcd(a, b);
        if (gcdValue != 0)
            return a * b / gcd(a, b);
        else
            return 0;
    }
}