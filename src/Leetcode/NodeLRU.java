package Leetcode;

public class NodeLRU {
	int key;
	int value;
	NodeLRU pre;
	NodeLRU next;

	public NodeLRU(int key, int value) {
		this.key = key;
		this.value = value;
	}
}
