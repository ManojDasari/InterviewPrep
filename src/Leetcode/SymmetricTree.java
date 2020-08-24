package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3
 

Follow up: Solve it both recursively and iteratively.
 */

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		return checkSymmetryIterative(root);
	}

	public boolean checkSymmetry(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;

		return (root1.val == root2.val) && (checkSymmetry(root1.left, root2.right))
				&& (checkSymmetry(root1.right, root2.left));
	}

	public boolean checkSymmetryIterative(TreeNode root) {
		if (root == null)
			return true;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode t1 = queue.poll();
			TreeNode t2 = queue.poll();
			if (t1 == null && t2 == null)
				continue;
			if (t1 == null || t2 == null)
				return false;
			if (t1.val != t2.val)
				return false;
			queue.add(t1.left);
			queue.add(t2.right);
			queue.add(t1.right);
			queue.add(t2.left);
		}
		return true;
	}
}
