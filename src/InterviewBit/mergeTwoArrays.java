package InterviewBit;

import java.util.ArrayList;

public class mergeTwoArrays {
	public static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
		int p1 = 0, p2 = 0, p3 = 0;
		while (p1 < a.size() && p2 < b.size()) {
			if (a.get(p1) <= b.get(p2)) {
				a.set(p3++, a.get(p1++));
			} else {
				a.add(p3++, b.get(p2++));
				p1++;
			}
		}
		while (p1 < a.size())
			a.set(p3++, a.get(p1++));
		while (p2 < b.size())
			a.add(p3++, b.get(p2++));
		System.out.println(a);
	}

	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list1.add(0, 1);
		list1.add(1, 2);
		list1.add(2, 5);
		list2.add(0, 1);
		list2.add(1, 7);
		list2.add(2, 8);
		list2.add(3, 9);
		merge(list1, list2);
	}
}
