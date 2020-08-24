package Leetcode;
/*
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

 

Follow up:

You may only use constant extra space.
Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
 

Example 1:


Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 

Constraints:

The number of nodes in the given tree is less than 4096.
-1000 <= node.val <= 1000
 */

import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public Node connect(Node root) {
		if (root == null)
			return null;
		Queue<Node> queue = new LinkedList<>();
		int size = -1;
		Node node = root, curNode = null;
		queue.add(node);
		while (!queue.isEmpty()) {
			size = queue.size();
			while (size > 0) {
				curNode = queue.poll();
				if (size == 1)
					curNode.next = null;
				if (size > 1) {
					curNode.next = queue.peek();
				}

				if (curNode.left != null)
					queue.add(curNode.left);
				if (curNode.right != null)
					queue.add(curNode.right);

				size--;
			}
		}
		return node;

	}
}
