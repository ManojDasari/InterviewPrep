package Hackerrank;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class mergeLinkedList {

	static class SinglyLinkedListNode {
		public int data;
		public SinglyLinkedListNode next;

		public SinglyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
		}
	}

	static class SinglyLinkedList {
		public SinglyLinkedListNode head;
		public SinglyLinkedListNode tail;

		public SinglyLinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void insertNode(int nodeData) {
			SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

			if (this.head == null) {
				this.head = node;
			} else {
				this.tail.next = node;
			}

			this.tail = node;
		}
	}

	public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter)
			throws IOException {
		while (node != null) {
			bufferedWriter.write(String.valueOf(node.data));

			node = node.next;

			if (node != null) {
				bufferedWriter.write(sep);
			}
		}
	}

	// Complete the mergeLists function below.

	/*
	 * For your reference:
	 *
	 * SinglyLinkedListNode { int data; SinglyLinkedListNode next; }
	 *
	 */
	static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
		SinglyLinkedListNode temp1 = head1;
		SinglyLinkedListNode temp2 = head2;
		SinglyLinkedListNode finallist = null;
		SinglyLinkedListNode root = null;
		if (temp1.data < temp2.data) {
			finallist = temp1;
			temp1 = temp1.next;
		} else {
			finallist = temp2;
			temp2 = temp2.next;
		}
		root = finallist;
		while (temp1 != null && temp2 != null) {
			if (temp1.data < temp2.data) {
				finallist.next = temp1;
				temp1 = temp1.next;
			} else {
				finallist.next = temp2;
				temp2 = temp2.next;
			}
			finallist=finallist.next;
		}
		while (temp1 != null) {
			finallist.next = temp1;
			temp1 = temp1.next;
			finallist=finallist.next;
		}
		while (temp2 != null) {
			finallist.next = temp2;
			temp2 = temp2.next;
			finallist=finallist.next;
		}
		return root;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int tests = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int testsItr = 0; testsItr < tests; testsItr++) {
			SinglyLinkedList llist1 = new SinglyLinkedList();

			int llist1Count = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < llist1Count; i++) {
				int llist1Item = scanner.nextInt();
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				llist1.insertNode(llist1Item);
			}

			SinglyLinkedList llist2 = new SinglyLinkedList();

			int llist2Count = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < llist2Count; i++) {
				int llist2Item = scanner.nextInt();
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				llist2.insertNode(llist2Item);
			}

			SinglyLinkedListNode llist3 = mergeLists(llist1.head, llist2.head);

			printSinglyLinkedList(llist3, " ", bufferedWriter);
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}
