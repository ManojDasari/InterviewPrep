package Hackerrank;

/*
 * In this challenge, you will be given a string. You must remove characters until the string is made up of any two alternating characters. When you choose a character to remove, all instances of that character must be removed. Your goal is to create the longest string possible that contains just two alternating letters.

As an example, consider the string abaacdabd. If you delete the character a, you will be left with the string bcdbd. Now, removing the character c leaves you with a valid string bdbd having a length of 4. Removing either b or d at any point would not result in a valid string.

Given a string , convert it to the longest possible string  made up only of alternating characters. Print the length of string  on a new line. If no string  can be formed, print  instead.

Function Description

Complete the alternate function in the editor below. It should return an integer that denotes the longest string that can be formed, or  if it cannot be done.

alternate has the following parameter(s):

s: a string
Input Format

The first line contains a single integer denoting the length of .
The second line contains string .

Constraints

Output Format

Print a single integer denoting the maximum length of  for the given ; if it is not possible to form string , print  instead.

Sample Input

10
beabeefeab
Sample Output

5
Explanation

The characters present in  are a, b, e, and f. This means that  must consist of two of those characters and we must delete two others. Our choices for characters to leave are [a,b], [a,e], [a, f], [b, e], [b, f] and [e, f].

If we delete e and f, the resulting string is babab. This is a valid  as there are only two distinct characters (a and b), and they are alternating within the string.

If we delete a and f, the resulting string is bebeeeb. This is not a valid string  because there are consecutive e's present. Removing them would leave consecutive b's, so this fails to produce a valid string .

Other cases are solved similarly.

babab is the longest string we can create.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TwoCharacter {

	// Complete the alternate function below.
	static int alternate(String s) {
		int maxLength = 0;
		if (s.length() == 1) {
			return maxLength;
		}
		for (int i = 0; i < 26; i++) {
			nextletter: for (int j = i + 1; j < 25; j++) {
				char start = (char) ('a' + i);
				char end = (char) ('a' + j);
				char lastseen = '\u0000';
				int currLength = 0;
				for (Character ch : s.toCharArray()) {
					if (start == ch || end == ch) {
						if (ch == lastseen) {
							continue nextletter;
						}
						currLength++;
						lastseen = ch;
					}
				}
				maxLength = Math.max(maxLength, currLength);
			}
		}
		return maxLength;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int l = Integer.parseInt(bufferedReader.readLine().trim());

		String s = bufferedReader.readLine();

		int result = alternate(s);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
