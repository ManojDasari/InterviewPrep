package FinalTestSI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ContinousHeight {
	static int maxHeight = 0;

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
			maxHeight = 0;
			for (int j = 0; j < t; j++) {
				root = insert(root, Integer.parseInt(arr[j]), 0, bufferedWriter);
			}
			bufferedWriter.write("\n");
		}
		bufferedWriter.flush();
	}

	public static int height(Node root) {
		if (root == null)
			return -1;
		return 1 + Math.max(height(root.left), height(root.right));

	}

	public static Node insert(Node root, int data, int height, BufferedWriter bw) throws IOException {
		if (root == null) {
			maxHeight = Math.max(maxHeight, height);
			bw.write(maxHeight + " ");
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data, height + 1, bw);
				root.left = cur;
			} else {
				cur = insert(root.right, data, height + 1, bw);
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

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}
