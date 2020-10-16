package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class NodesAtDistancek {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			String[] arr = bufferedReader.readLine().trim().split(" ");
			int t = Integer.parseInt(arr[0]);
			Node root = null;
			String[] input = bufferedReader.readLine().trim().split(" ");
			for (int j = 0; j < t; j++) {
				root = insert(root, Integer.parseInt(input[j]));
			}
			int s = Integer.parseInt(arr[1]);
			int k = Integer.parseInt(arr[2]);
			atDistanceK(root, s, k, bufferedWriter);
		}
		bufferedWriter.flush();
	}

	public static void atDistanceK(Node root, int s, int k, BufferedWriter bw) throws IOException {
		List<Node> arr = new ArrayList<Node>();
		findPath(root, s, arr);
		int ans = count(arr.get(0), k);
		for (int i = 1; i < arr.size(); i++) {
			if (arr.get(i).left == arr.get(i - 1)) {
				ans += count(arr.get(i).right, k - i - 1);
			} else {
				ans += count(arr.get(i).left, k - i - 1);
			}
		}
		if(k<arr.size())
			bw.write((ans + 1) + "\n");
		else
			bw.write((ans) + "\n");
	}

	public static boolean findPath(Node root, int a, List<Node> ls) {
		if (root == null)
			return false;
		if (root.data == a) {
			ls.add(root);
			return true;
		}
		if (findPath(root.left, a, ls)) {
			ls.add(root);
			return true;
		}
		if (findPath(root.right, a, ls)) {
			ls.add(root);
			return true;
		}
		return false;
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

	public static int count(Node root, int k) {
		if (root == null || k < 0)
			return 0;
		if (k == 0)
			return 1;
		return count(root.left, k - 1) + count(root.right, k - 1);
	}
}

class Node {
	Node left;
	Node right;
	int data;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}
