package InterviewBit;

import java.util.ArrayList;

public class Diffk {
	public static int diffPossible(ArrayList<Integer> A, int B) {
		int idx1 = 0;
		int idx2 = 1;
		int n = A.size();
		while (idx1 < n && idx2 < n) {
			if (idx1 != idx2 && A.get(idx2) - A.get(idx1) == B) {
				return 1;
			}
			if (A.get(idx2) - A.get(idx1) < B) {
				idx2++;
			} else {
				idx1++;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0, 1);
		list.add(1, 5);
		diffPossible(list, 4);
	}
}
