package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class verticalOrderTraversal {
	static int mv = 0;

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			mv = 0;
			int t = Integer.parseInt(bufferedReader.readLine().trim());
			String[] arr = bufferedReader.readLine().trim().split(" ");
			Node root = null;
			HashMap<Integer, List<Integer>> hm = new HashMap<Integer, List<Integer>>();
			for (int j = 0; j < t; j++) {
				root = insert(root, Integer.parseInt(arr[j]));
			}
			verticalOrder(root, hm, 0, bufferedWriter);
			while (true) {
				if (!hm.containsKey(mv))
					break;
				List<Integer> temp = hm.get(mv);
				Collections.sort(temp);
				for (int j : temp) {
					bufferedWriter.write(j + " ");
				}
				mv++;
				bufferedWriter.write("\n");
			}
			bufferedWriter.write("\n");
		}
		bufferedWriter.flush();
	}

	public static void verticalOrder(Node root, HashMap<Integer, List<Integer>> hm, int v, BufferedWriter bw)
			throws IOException {
		if (root == null)
			return;
		List<Integer> temp = hm.get(v);
		if (temp != null)
			hm.get(v).add(root.data);
		else {
			hm.put(v, new ArrayList<Integer>());
			hm.get(v).add(root.data);
		}
		verticalOrder(root.left, hm, v - 1, bw);
		mv = Math.min(mv, v);
		verticalOrder(root.right, hm, v + 1, bw);
		return;
	}

	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}
}
