package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class isAnagrams {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			StringBuilder array = new StringBuilder();
			String[] arr = array.append(bufferedReader.readLine().trim()).toString().split(" ");
			StringBuilder input1 = new StringBuilder(arr[0]);
			StringBuilder input2 = new StringBuilder(arr[1]);
			isAnagram(input1, input2);
		}
	}

	public static void isAnagram(StringBuilder input1, StringBuilder input2) {
		int[] countArray = new int[27];
		for (Character ch : input1.toString().toCharArray()) {
			countArray[ch - 'a']++;
		}
		for (Character ch : input2.toString().toCharArray()) {
			countArray[ch - 'a']--;
		}
		for (int i = 0; i < 26; i++) {
			if (countArray[i] > 0) {
				System.out.println("False");
				return;
			}
		}
		System.out.println("True");
	}
}