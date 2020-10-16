package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class AnyMedian {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(bufferedReader.readLine());
		for (int i = 0; i < testCases; i++) {
			PriorityQueue<Integer> lQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
			PriorityQueue<Integer> rQueue = new PriorityQueue<Integer>();
			int N = Integer.parseInt(bufferedReader.readLine().trim());
			String[] arr = bufferedReader.readLine().trim().split(" ");
			anytimeMedian(lQueue, rQueue, arr);
			System.out.println();
		}
	}

	public static void anytimeMedian(PriorityQueue<Integer> l, PriorityQueue<Integer> r, String[] input) {
		for (String s : input) {
			if (l.isEmpty())
				l.add(Integer.parseInt(s));
			else if (Integer.parseInt(s) > l.peek()) {
				r.add(Integer.parseInt(s));
			} else {
				l.add(Integer.parseInt(s));
			}
			while (l.size() - r.size() != 0 && l.size() - r.size() != 1) {
				if (r.size() > l.size()) {
					int temp = r.poll();
					l.add(temp);
				} else {
					int temp = l.poll();
					r.add(temp);
				}
			}
			System.out.print(l.peek() + " ");
		}
	}
}