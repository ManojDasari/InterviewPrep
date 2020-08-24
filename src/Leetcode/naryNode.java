package Leetcode;

import java.util.List;

public class naryNode {
	    public int val;
	    public List<Node> children;

	    public naryNode() {}

	    public naryNode(int _val) {
	        val = _val;
	    }

	    public naryNode(int _val, List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
}
