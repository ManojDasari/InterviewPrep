package InterviewBit;

import java.util.HashSet;

public class TwoSum {
	public static int colorful(int A) {
		HashSet<Integer> result = new HashSet<Integer>();
		char[] charArray = String.valueOf(A).toLowerCase().toCharArray();
		for (int i = 0; i < (1 << charArray.length); i++) {
			int product = 1;
			for (int j = 0; j < charArray.length; j++) {
				if ((i & (1 << j)) > 0) {
					product = product * (charArray[j] - '0');
				}
			}
			if (result.contains(product)) {
				return 0;
			}else
				result.add(product);
		}
		return 1;
	}
	public static void main(String[] args) {
		colorful(263);
	}
}
