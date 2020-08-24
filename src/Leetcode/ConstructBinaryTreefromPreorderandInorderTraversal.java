package Leetcode;
/*
 * Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 */

public class ConstructBinaryTreefromPreorderandInorderTraversal {
	int preOrderIndex = 0;

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return helper(preorder, inorder, 0, preorder.length - 1);
	}

	public TreeNode helper(int[] preorder, int[] inorder, int inStart, int inEnd) {
		if (inStart > inEnd) {
			return null;
		}

		TreeNode node = new TreeNode(preorder[preOrderIndex++]);

		if (inStart == inEnd) {
			return node;
		}

		int index = search(inorder, inStart, inEnd, node.val);

		node.left = helper(preorder, inorder, inStart, index - 1);
		node.right = helper(preorder, inorder, index + 1, inEnd);

		return node;
	}

	public int search(int[] inorder, int inStart, int inEnd, int value) {
		int ans = 0;
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == value) {
				ans = i;
			}
		}
		return ans;
	}
}