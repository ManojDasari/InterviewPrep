package Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 */
public class BinaryTreeZigzagLevelOrderTraversal {
	List<List<Integer>> list;

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		this.list = new ArrayList<>();
		dfs(root, 0);
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				if (i % 2 == 1) {
					Collections.reverse(list.get(i));
				}
			}
		}
		return list;
	}

	public void dfs(TreeNode node, int depth) {
		if (node == null)
			return;
		if (list.size() < depth + 1) {
			list.add(new ArrayList<>());
		}
		list.get(depth).add(node.val);
		dfs(node.left, depth + 1);
		dfs(node.right, depth + 1);
	}
}