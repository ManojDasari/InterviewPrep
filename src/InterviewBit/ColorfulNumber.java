package InterviewBit;

/*
 * For Given Number N find if its COLORFUL number or not

Return 0/1

COLORFUL number:

A number can be broken into different contiguous sub-subsequence parts. 
Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245. 
And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different
Example:

N = 23
2 3 23
2 -> 2
3 -> 3
23 -> 6
this number is a COLORFUL number since product of every digit of a sub-sequence are different. 

Output : 1
 */
import java.util.HashSet;

public class ColorfulNumber {
	public int colorful(int A) {
		if (A >= 0 && A < 10)
			return 1;
		if (A < 0)
			A *= -1;
		HashSet<Integer> result = new HashSet<Integer>();
		char[] charArray = String.valueOf(A).toLowerCase().toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			int product = 1;
			for (int j = i; j < charArray.length; j++) {
				product *= charArray[j] - '0';
				if (result.contains(product)) {
					return 0;
				}
				result.add(product);
			}
		}
		return 1;
	}
}
