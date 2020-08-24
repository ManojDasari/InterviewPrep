package Leetcode;

import java.util.HashSet;
import java.util.Set;

/*
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:

Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
 

Example 2:

Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
 */
public class TwoSumIVInputisaBST {
	public boolean findTarget(TreeNode root, int k) {
		Set<Integer> set = new HashSet();
		return searchBT(root, k, set);

	}

	public boolean searchBT(TreeNode root, int k, Set<Integer> set) {
		if (root == null)
			return false;
		if (set.contains(k - root.val))
			return true;
		set.add(root.val);
		return searchBT(root.left, k, set) || searchBT(root.right, k, set);
	}
}
