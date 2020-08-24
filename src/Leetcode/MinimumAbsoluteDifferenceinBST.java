package Leetcode;

public class MinimumAbsoluteDifferenceinBST {
	int ans = Integer.MAX_VALUE;
	Integer prev = null;

	public int getMinimumDifference(TreeNode root) {
		if (root.left != null)
			getMinimumDifference(root.left);
		if (prev != null)
			ans = Math.min(root.val - prev, ans);
		prev = root.val;
		if (root.right != null)
			getMinimumDifference(root.right);

		return ans;
	}
}
