package InterviewBit;

import java.util.ArrayList;
import java.util.Collections;

/*
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.

 Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
The subsets must be sorted lexicographically.
Example :
If S = [1,2,2], the solution is:

[
[],
[1],
[1,2],
[1,2,2],
[2],
[2, 2]
]
 */
public class SubsetsII {

	public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		Collections.sort(A);
		helper(A, new ArrayList<>(), ans, 0);
		return ans;
	}

	private void helper(ArrayList<Integer> a, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> ans, int idx) {
		ans.add(new ArrayList<>(curr));
		if (idx >= a.size()) {
			return;
		}
		for (int i = idx; i < a.size(); i++) {
			if (i > idx && a.get(i).equals(a.get(i - 1))) {
				continue;
			}
			curr.add(a.get(i));
			helper(a, curr, ans, i + 1);
			curr.remove(curr.size() - 1);
		}
	}
}
