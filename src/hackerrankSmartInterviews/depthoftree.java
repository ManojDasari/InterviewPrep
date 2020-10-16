package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class depthoftree {

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
			depth(root, 0);
			for (int j = 0; j < t; j++) {
				Node temp = search(root, Integer.parseInt(arr[j]));
				bufferedWriter.write(temp.depth + " ");
			}
			bufferedWriter.write("\n");
		}
		bufferedWriter.flush();
	}

	public static void depth(Node root, int d) {
		if (root == null)
			return;
		root.depth = d;
		depth(root.left, d + 1);
		depth(root.right, d + 1);
	}

	public static Node search(Node root, int k) {
		if (root == null)
			return null;
		if (root.data == k)
			return root;
		if (root.data < k)
			return search(root.right, k);
		return search(root.left, k);
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

class Node {
	Node left;
	Node right;
	int data;
	int depth;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}
