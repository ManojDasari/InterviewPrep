package Leetcode;

import java.util.HashMap;

/*
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2  //capacity  );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
 */
public class LRUCache {
	private HashMap<Integer, NodeLRU> map;
	private int capicity, count;
	private NodeLRU head, tail;

	public LRUCache(int capacity) {
		this.capicity = capacity;
		map = new HashMap<>();
		head = new NodeLRU(0, 0);
		tail = new NodeLRU(0, 0);
		head.next = tail;
		tail.pre = head;
		head.pre = null;
		tail.next = null;
		count = 0;
	}

	public int get(int key) {
		if (map.get(key) != null) {
			NodeLRU node = map.get(key);
			int result = node.value;
			deleteNode(node);
			addToHead(node);
			System.out.println("Got the value : " + result + " for the key: " + key);
			return result;
		}
		System.out.println("Did not get any value" + " for the key: " + key);
		return -1;
	}

	public void put(int key, int value) {
		if (map.get(key) != null) {
			NodeLRU node = map.get(key);
			node.value = value;
			deleteNode(node);
			addToHead(node);
		} else {
			NodeLRU node = new NodeLRU(key, value);
			map.put(key, node);
			if (count < capicity) {
				count++;
				addToHead(node);
			} else {
				map.remove(tail.pre.key);
				deleteNode(tail.pre);
				addToHead(node);
			}
		}
	}

	public void deleteNode(NodeLRU node) {
		node.pre.next = node.next;
		node.next.pre = node.pre;
	}

	public void addToHead(NodeLRU node) {
		node.next = head.next;
		node.next.pre = node;
		node.pre = head;
		head.next = node;
	}

}
