package InterviewBit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ThreeSumZeroInterviewbit {
	public static ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
		Collections.sort(A);
		Set<ArrayList<Integer>> result = new HashSet();
		for (int i = 0; i < A.size() - 2; i++) {
			int k = i + 1;
			int l = A.size() - 1;

			while (k < l) {
				if ((long)A.get(i) + A.get(k) + A.get(l) == (long)0) {
					ArrayList<Integer> tempArray = new ArrayList<Integer>();
					tempArray.add(0, A.get(i));
					tempArray.add(1, A.get(k));
					tempArray.add(2, A.get(l));
					result.add(tempArray);
					k++;
				} else if (A.get(k) + A.get(l) + A.get(i) < 0)
					k++;
				else
					l--;
			}
		}
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		Iterator<ArrayList<Integer>> i = result.iterator();
		while (i.hasNext()) {
			res.add(i.next());
		}
		return res;
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(2147483647);
		list.add(-2147483648);
		list.add(-2147483648);
		list.add(0);
		list.add(1);
		threeSum(list);
	}
}
