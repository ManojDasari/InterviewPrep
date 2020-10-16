package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class bottomUpLevelOrder {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			int t = Integer.parseInt(bufferedReader.readLine().trim());
			String[] arr = bufferedReader.readLine().trim().split(" ");
			Node root = null;
			for (int j = 0; j < t; j++) {
				root = insert(root, Integer.parseInt(arr[j]));
			}
			levelOrder(root, bufferedWriter);
			bufferedWriter.write("\n");
		}
		bufferedWriter.flush();
	}

	public static void levelOrder(Node root, BufferedWriter bw) throws IOException {
		if (root == null)
			return;
		Queue<Node> q = new LinkedList<Node>();
		HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		int level = 0;
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> t = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				Node temp = q.poll();
				t.add(temp.data);
				if (temp.left != null)
					q.add(temp.left);
				if (temp.right != null)
					q.add(temp.right);
			}
			map.put(level++, t);
		}
		for (int i = level - 1; i >= 0; i--) {
			List<Integer> list = map.get(i);
			for (Object i1 : list.toArray()) {
				bw.write(i1 + " ");
			}
			bw.write("\n");
		}
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
