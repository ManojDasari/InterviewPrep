package Leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * Print a binary tree in an m*n 2D string array following these rules:

The row number m should be equal to the height of the given binary tree.
The column number n should always be an odd number.
The root node's value (in string format) should be put in the exactly middle of the first row it can be put. The column and the row where the root node belongs will separate the rest space into two parts (left-bottom part and right-bottom part). You should print the left subtree in the left-bottom part and print the right subtree in the right-bottom part. The left-bottom part and the right-bottom part should have the same size. Even if one subtree is none while the other is not, you don't need to print anything for the none subtree but still need to leave the space as large as that for the other subtree. However, if two subtrees are none, then you don't need to leave space for both of them.
Each unused space should contain an empty string "".
Print the subtrees following the same rules.
Example 1:
Input:
     1
    /
   2
Output:
[["", "1", ""],
 ["2", "", ""]]
Example 2:
Input:
     1
    / \
   2   3
    \
     4
Output:
[["", "", "", "1", "", "", ""],
 ["", "2", "", "", "", "3", ""],
 ["", "", "4", "", "", "", ""]]
Example 3:
Input:
      1
     / \
    2   5
   / 
  3 
 / 
4 
Output:

[["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
Note: The height of binary tree is in the range of [1, 10].
 */
public class printBinaryTree {
	public List<List<String>> printTree(TreeNode root) {

		List<List<String>> res = new ArrayList<>();
		int depth = max_depth(root);
		String[][] arr = new String[depth][(1 << depth) - 1];

		fill(arr, root, 0, 0, arr[0].length);

		for (int i = 0; i < arr.length; i++) {
			List<String> temp = new ArrayList<>();

			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] != null)
					temp.add(arr[i][j]);
				else
					temp.add("");

			}

			res.add(temp);
		}

		return res;
	}

	public void fill(String[][] arr, TreeNode root, int i, int l, int r) {
		if (root == null)
			return;

		arr[i][(l + r) / 2] = "" + root.val;

		fill(arr, root.left, i + 1, l, (l + r) / 2);
		fill(arr, root.right, i + 1, (l + r + 1) / 2, r);

	}

	public int max_depth(TreeNode root) {

		if (root == null)
			return 0;

		return 1 + Math.max(max_depth(root.left), max_depth(root.right));

	}

}
