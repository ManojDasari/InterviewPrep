package InterviewBit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Given a list of non negative integers, arrange them such that they form the largest number.

For example:

Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {

	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public String largestNumber(final List<Integer> A) {
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < A.size(); i++) {
			result.add(i, Integer.toString(A.get(i)));
		}
		StringBuilder str = new StringBuilder();
		Collections.sort(result, (x, y) -> {
			String xy = x.toString() + y.toString();
			String yx = y.toString() + x.toString();
			return xy.compareTo(yx) > 0 ? -1 : 1;
		});
		for (String s : result) {
			if (s.equals("0"))
				return "0";
			str.append(s);
		}
		return str.toString();
	}

}
