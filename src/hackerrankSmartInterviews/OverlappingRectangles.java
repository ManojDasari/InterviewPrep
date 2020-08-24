package hackerrankSmartInterviews;
/*
 * Given 2 rectangles parallel to coordinate axes, find the area covered by them.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines. First line of each test case contains 4 integers - xbl, ybl, xtr, ytr - the bottom-left and top-right coordinates of rectangle-1. The second line of each test case contains 4 integers - xbl, ybl, xtr, ytr - the bottom-left and top-right coordinates of rectangle-2.

Constraints

1 <= T <= 10000
-106 < x,y <= 106
(xbl, ybl) < (xtr, ytr)

Output Format

For each test case, print the area covered by the 2 rectangles, separated by newline.

Sample Input 0

4
2 5 4 6
1 2 5 4
-4 -3 -2 5
-3 -5 1 3
1 0 3 5
2 3 5 8
-2 2 4 4
-3 1 5 5
Sample Output 0

10
42
23
32
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class OverlappingRectangles {

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	};

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			String[] input1 = bufferedReader.readLine().trim().split(" ");
			String[] input2 = bufferedReader.readLine().trim().split(" ");
			Point A1 = new Point(Integer.parseInt(input1[0]), Integer.parseInt(input1[1]));
			Point B1 = new Point(Integer.parseInt(input1[2]), Integer.parseInt(input1[3]));
			Point A2 = new Point(Integer.parseInt(input2[0]), Integer.parseInt(input2[1]));
			Point B2 = new Point(Integer.parseInt(input2[2]), Integer.parseInt(input2[3]));
			area(A1, B1, A2, B2);
		}
	}

	public static void area(Point A1, Point B1, Point A2, Point B2) {
		BigInteger area1 = BigInteger.valueOf((long) Math.abs(A1.x - B1.x) * Math.abs(A1.y - B1.y));
		BigInteger area2 = BigInteger.valueOf((long) Math.abs(A2.x - B2.x) * Math.abs(A2.y - B2.y));
		BigInteger intersection = BigInteger.ZERO;
		if (doOverlap(A1, B1, A2, B2))
			intersection = BigInteger.valueOf((long) (Math.min(B1.x, B2.x) - Math.max(A1.x, A2.x))
					* (Math.min(B1.y, B2.y) - Math.max(A1.y, A2.y)));
		BigInteger result = area1.add(area2);
		System.out.println(result.subtract(intersection));
	}

	static boolean doOverlap(Point l1, Point r1, Point l2, Point r2) {
		if (l1.x >= r2.x || l2.x >= r1.x || l1.y >= r2.y || l2.y >= r1.y) {
			return false;
		}

		return true;
	}
}
