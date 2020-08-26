package InterviewBit;

/*
 * Find the largest continuous sequence in a array which sums to zero.

Example:


Input:  {1 ,2 ,-2 ,4 ,-4}
Output: {2 ,-2 ,4 ,-4}

 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LargestContinuousSequenceZeroSum {
	public static ArrayList<Integer> lszero(ArrayList<Integer> A) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int left = -1, right = -1;
		int sum = 0;
		for (int i = 0; i < A.size(); i++) {
			sum += A.get(i);
			if (A.get(i) == 0) {
				if ((right - left) < 1) {
					left = i;
					right = i;
				}
			}
			if (sum == 0) {
				if ((right - left) < (i + 1)) {
					left = 0;
					right = i;
				}
			}
			if (map.containsKey(sum)) {
				if ((right - left) < (i - map.get(sum) - 1)) {
					left = map.get(sum) + 1;
					right = i;
				}
			} else {
				map.put(sum, i);
			}
		}
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (left != -1) {
			for (int i = left; i <= right; i++) {
				result.add(A.get(i));
			}
		}
		return result;
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0, 1);
		list.add(1, 2);
		list.add(2, -2);
		list.add(3, 4);
		list.add(4, -4);
		lszero(list);
	}
}
