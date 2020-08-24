package hackerrankSmartInterviews;

/*
 * Given an array of unique integer elements, print all the subsets of the given array in lexicographical order.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines, the first line contains N - the size of the array and second line contains the elements of the array.

Constraints

1 <= T <= 100
1 <= N <= 10
0 <= A[i] <= 100

Output Format

For each test case, print the subsets of the given array in lexicographical order, separated by new line. Print an extra newline between output of different test cases.

Sample Input 0

3
3
5 15 3 
2
57 96 
4
3 15 8 23 
Sample Output 0

3 
3 5 
3 5 15 
3 15 
5 
5 15 
15 

57 
57 96 
96 

3 
3 8 
3 8 15 
3 8 15 23 
3 8 23 
3 15 
3 15 23 
3 23 
8 
8 15 
8 15 23 
8 23 
15 
15 23 
23 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Subsetsofanarray {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(bufferedreader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			int count = Integer.parseInt(bufferedreader.readLine().trim());
			String[] array = bufferedreader.readLine().trim().split(" ");
			ArrayList<Integer> input = new ArrayList<Integer>();
			for (int j = 0; j < count; j++) {
				input.add(Integer.parseInt(array[j]));
			}
			ArrayList<ArrayList<Integer>> result = subsets(input);
			for (ArrayList<Integer> list : result) {
				for (int value : list) {
					System.out.print(value + " ");
				}
				System.out.println("");
			}
			System.out.println("");
		}
	}

	public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
		if (a == null)
			return null;
		Collections.sort(a);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < a.size(); i++) {
			ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();

			for (ArrayList<Integer> list : result) {
				temp.add(new ArrayList<Integer>(list));
			}

			for (ArrayList<Integer> list : temp) {
				list.add(a.get(i));
			}
			ArrayList<Integer> single = new ArrayList<Integer>();
			single.add(a.get(i));
			temp.add(single);

			result.addAll(temp);
		}

		Collections.sort(result, new Comparator<ArrayList<Integer>>() {
			@Override
			public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
				int an = a.size();
				int bn = b.size();
				for (int i = 0; i < Math.min(an, bn); i++) {
					int cmp = Integer.compare(a.get(i), b.get(i));
					if (cmp != 0)
						return cmp;
				}
				return Integer.compare(a.size(), b.size());
			}
		});

		return result;
	}
}