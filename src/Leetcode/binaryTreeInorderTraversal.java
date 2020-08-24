package Leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class binaryTreeInorderTraversal {
	List<Integer> result = new ArrayList<Integer>();

	public List<Integer> inorderTraversal(TreeNode root) {
		inorder(root);
		return result;
	}

	public void inorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.left);
		result.add(root.val);
		inorder(root.right);
	}
}