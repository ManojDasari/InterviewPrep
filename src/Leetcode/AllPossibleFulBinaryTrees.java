package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * A full binary tree is a binary tree where each node has exactly 0 or 2 children.

Return a list of all possible full binary trees with N nodes.  Each element of the answer is the root node of one possible tree.

Each node of each tree in the answer must have node.val = 0.

You may return the final list of trees in any order.

 

Example 1:

Input: 7
Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
Explanation:

 

Note:

1 <= N <= 20
 */
public class AllPossibleFulBinaryTrees {
	Map<Integer, List<TreeNode>> map = new HashMap<>();

	public List<TreeNode> allPossibleFBT(int n) {

		if (map.containsKey(n))
			return map.get(n);

		List<TreeNode> list = new ArrayList<>();
		if (n == 0 || n % 2 == 0) {
			return list;
		} else if (n == 1) {
			list.add(new TreeNode(0));
			map.put(1, list);
			return list;
		} else {

			for (int i = 1; i < n; i += 2) {
				List<TreeNode> left = allPossibleFBT(i);
				List<TreeNode> right = allPossibleFBT(n - 1 - i);

				for (int j = 0; j < left.size(); j++) {
					for (int k = 0; k < right.size(); k++) {
						TreeNode root = new TreeNode(0);
						root.left = left.get(j);
						root.right = right.get(k);
						list.add(root);
					}
				}
			}

		}

		map.put(n, list);
		return list;

	}
}
