package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class KMPAlgo {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			String[] input = bufferedReader.readLine().trim().split(" ");
			bufferedWriter.write(KMPSearch(input[1], input[0]) + "\n");
		}
		bufferedWriter.flush();
	}

	public static int KMPSearch(String str, String pat) {
		int strLen = str.length();
		int patLen = pat.length();
		int result = 0;
		int[] lpsArr = new int[patLen];
		int j = 0;
		computeLPS(pat, patLen, lpsArr);
		int i = 0;
		while (i < strLen) {
			if (pat.charAt(j) == str.charAt(i)) {
				i++;
				j++;
			}
			if (j == patLen) {
				result++;
				j = lpsArr[j - 1];
			} else if (i < strLen && pat.charAt(j) != str.charAt(i)) {
				if (j != 0) {
					j = lpsArr[j - 1];
				} else {
					i = i + 1;
				}
			}
		}
		return result;
	}

	public static void computeLPS(String pat, int N, int[] lpsArr) {
		int prevLen = 0;
		int i = 1;
		lpsArr[0] = 0;
		while (i < N) {
			if (pat.charAt(i) == pat.charAt(prevLen)) {
				prevLen++;
				lpsArr[i] = prevLen;
				i++;
			} else {
				if (prevLen != 0) {
					prevLen = lpsArr[prevLen - 1];
				} else {
					lpsArr[i] = prevLen;
					i++;
				}
			}
		}

	}
}