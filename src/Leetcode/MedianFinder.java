package Leetcode;

import java.util.PriorityQueue;

/*
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
 */
public class MedianFinder {
	PriorityQueue<Integer> low = new PriorityQueue<Integer>((a, b) -> (b - a));
	PriorityQueue<Integer> hi = new PriorityQueue<Integer>();

	/**
	 * initialize your data structure here.
	 * 
	 * @return
	 */
	public MedianFinder() {

	}

	public void addNum(int num) {
		low.add(num);
		hi.add(low.poll());
		if (low.size() < hi.size()) {
			low.add(hi.poll());
		}
	}

	public double findMedian() {
		return low.size() > hi.size() ? low.peek() : (low.peek() + hi.peek()) / 2.0;
	}
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder(); obj.addNum(num); double param_2 =
 * obj.findMedian();
 */
