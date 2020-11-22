package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BinaryStringswithnoadjacent1s {
	static int[] dp = new int[100002];
    static int M = (int) (1e9 + 7);

    public static void main(String[] args) throws IOException {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCases = Integer.parseInt(bufferedReader.readLine().trim());
        countBinaryStrings(100001);
        for (int i = 0; i < testCases; i++) {
            int N = Integer.parseInt(bufferedReader.readLine().trim());
            bufferedWriter.write(dp[N+1] + "\n");
        }
        bufferedWriter.flush();
    }

    public static void countBinaryStrings(int N) {
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % M;
        }
    }
}