package Leetcode;

/*
 * Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
 */
public class MasimumDepthofBinaryTree {
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;

		int ldepth = maxDepth(root.left);
		int rdepth = maxDepth(root.right);

		int bigger = Math.max(ldepth, rdepth);

		return bigger + 1;

	}

}
