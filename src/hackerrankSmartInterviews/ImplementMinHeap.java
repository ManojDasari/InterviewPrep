package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class ImplementMinHeap {
	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		MinHeap objMinHeap = new MinHeap();
		for (int i = 0; i < testCases; i++) {
			String[] arr = bufferedReader.readLine().trim().split(" ");
			if (arr[0].equalsIgnoreCase("insert")) {
				objMinHeap.insert(Integer.parseInt(arr[1]));
			} else if (arr[0].equalsIgnoreCase("getMin")) {
				int min = objMinHeap.getMin();
				bufferedWriter.write(min == -1 ? "Empty" + "\n" : min + "\n");
			} else if (arr[0].equalsIgnoreCase("delMin")) {
				objMinHeap.delMin();
			}
		}
		bufferedWriter.flush();
	}
}

class MinHeap {
	static ArrayList<Integer> heap;

	MinHeap() {
		heap = new ArrayList<Integer>();
	}

	void insert(int item) {
		heap.add(item);
		int i = heap.size() - 1;
		int parent = parent(i);
		while (parent != i && heap.get(i) < heap.get(parent)) {
			swap(i, parent);
			i = parent;
			parent = parent(i);
		}
	}

	int getMin() {
		if (heap.size() == 0) {
			return -1;
		}
		return heap.get(0);
	}

	static int parent(int i) {
		if (i % 2 == 1) {
			return i / 2;
		}
		return (i - 1) / 2;
	}

	static void swap(int i, int parent) {
		int temp = heap.get(parent);
		heap.set(parent, heap.get(i));
		heap.set(i, temp);
	}

	void delMin() {
		if (heap.size() == 0) {
			return;
		} else if (heap.size() == 1) {
			heap.remove(0);
			return;
		}
		heap.get(0);
		int lastItem = heap.remove(heap.size() - 1);
		heap.set(0, lastItem);
		minHeapify(0);
	}

	void minHeapify(int i) {
		int left = (2 * i) + 1;
		int right = (2 * i) + 2;
		int smallest = -1;
		if (left <= heap.size() - 1 && heap.get(left) < heap.get(i)) {
			smallest = left;
		} else {
			smallest = i;
		}
		if (right <= heap.size() - 1 && heap.get(right) < heap.get(smallest)) {
			smallest = right;
		}
		if (smallest != i) {
			swap(i, smallest);
			minHeapify(smallest);
		}
	}

}