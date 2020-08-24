package Leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 */
public class BinaryTreelevelOrderTraversal {
	List<List<Integer>> list;

	public List<List<Integer>> levelOrder(TreeNode root) {
		this.list = new ArrayList<>();
		dfs(root, 0);
		return list;
		// List<List<Integer>> result = new ArrayList<>();
		// if(root==null)
		// return result;
		// Queue<TreeNode> queue = new LinkedList<>();
		// queue.add(root);
		// while(!queue.isEmpty()){
		// int size = queue.size();
		// List<Integer> temp = new ArrayList<>();
		// for (int i=0; i<size; i++) {
		// TreeNode curr = queue.poll();
		// temp.add(curr.val);
		// if (curr.left != null) queue.add(curr.left);
		// if (curr.right != null) queue.add(curr.right);
		// }
		// result.add(temp);
		// }
		// return result;
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
