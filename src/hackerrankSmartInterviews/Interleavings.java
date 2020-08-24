package hackerrankSmartInterviews;

/*
 * Given 2 strings A and B, print all the interleavings of the 2 strings. An interleaved string of given two strings preserves the order of characters in individual strings and uses all the characters of both the strings. For simplicity, you can assume that the strings have unique characters.

Input Format

First line of input contains T - number of test cases. Its followed by T lines, each contains 2 space separated strings A and B.

Constraints

1 <= T <= 100
'a' <= A[i], B[i] <= 'z'
1 <= len(A), len(B) <= 10

Output Format

For each test case, print the test case number, followed by the interleavings of the 2 strings in a sorted order, separated by newline.

Sample Input 0

2
nkb gl
bn zh
Sample Output 0

Case #1:
glnkb
gnkbl
gnklb
gnlkb
ngkbl
ngklb
nglkb
nkbgl
nkgbl
nkglb
Case #2:
bnzh
bzhn
bznh
zbhn
zbnh
zhbn
 */
import java.io.*;
import java.util.*;

public class Interleavings {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			String[] array = bufferedReader.readLine().trim().split(" ");
			String input1 = array[0];
			String input2 = array[1];
			ArrayList<String> result = new ArrayList<String>();
			System.out.println("Case #" + (i + 1) + ":");
			interleavings(input1, input2, "", result);
			Collections.sort(result);
			for (String s : result)
				System.out.println(s);
		}
	}

	public static void interleavings(String input1, String input2, String interleaved, ArrayList<String> result) {
		if (input1.length() == 0 && input2.length() == 0)
			result.add(interleaved);
		if (input1.length() != 0) {
			interleavings(input1.substring(1), input2, interleaved + input1.charAt(0), result);
		}
		if (input2.length() != 0) {
			interleavings(input1, input2.substring(1), interleaved + input2.charAt(0), result);
		}
	}

}
