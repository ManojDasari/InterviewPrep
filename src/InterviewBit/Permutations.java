package InterviewBit;

import java.util.ArrayList;

/*
 * Given a collection of numbers, return all possible permutations.

Example:

[1,2,3] will have the following permutations:

[1,2,3]
[1,3,2]
[2,1,3] 
[2,3,1] 
[3,1,2] 
[3,2,1]
 NOTE
No two entries in the permutation sequence should be the same.
For the purpose of this problem, assume that all the numbers in the collection are unique.
 Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
Example : next_permutations in C++ / itertools.permutations in python.
If you do, we will disqualify your submission retroactively and give you penalty points. 

 */
public class Permutations {
	public void recur(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> a, ArrayList<Integer> temp) {

		if (a.size() == 0) {
			res.add(new ArrayList<Integer>(temp));
		}

		for (int i = 0; i < a.size(); i++) {
			temp.add(a.get(i));
			ArrayList<Integer> acopy = new ArrayList<Integer>(a);
			acopy.remove(i);
			recur(res, acopy, temp);
			temp.remove(temp.size() - 1);
		}
	}

	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {

		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		recur(res, a, new ArrayList<Integer>());
		return res;

	}
}
