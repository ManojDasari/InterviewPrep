package Hackerrank;

/*
 * We're going to make our own Contacts application! The application must perform two types of operations:

add name, where  is a string denoting a contact name. This must store  as a new contact in the application.
find partial, where  is a string denoting a partial name to search the application for. It must count the number of contacts starting with  and print the count on a new line.
Given  sequential add and find operations, perform each operation in order.

Input Format

The first line contains a single integer, , denoting the number of operations to perform.
Each line  of the  subsequent lines contains an operation in one of the two forms defined above.

Constraints

It is guaranteed that  and  contain lowercase English letters only.
The input doesn't have any duplicate  for the  operation.
Output Format

For each find partial operation, print the number of contact names starting with  on a new line.

Sample Input

4
add hack
add hackerrank
find hac
find hak
Sample Output

2
0
Explanation

We perform the following sequence of operations:

Add a contact named hack.
Add a contact named hackerrank.
Find and print the number of contact names beginning with hac. There are currently two contact names in the application and both of them start with hac, so we print  on a new line.
Find and print the number of contact names beginning with hak. There are currently two contact names in the application but neither of them start with hak, so we print  on a new line.
 */
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class contacts {

	/*
	 * Complete the contacts function below.
	 */
	static int[] contacts(String[][] queries) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		Trie trie = new Trie();
		for (int i = 0; i < queries.length; i++) {
			if (queries[i][0].equals("add")) {
				trie.addName(queries[i][1]);
			} else {
				result.add(trie.findPartial(queries[i][1]));
			}
		}
		int[] res = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			res[i] = result.get(i);
		}
		return res;
	}

	public static class Node {
		int occurences;
		Map<Character, Node> children = new HashMap<Character, Node>();

		public Node() {
			occurences = 1;
		}
	}

	public static class Trie {
		Node root;

		public Trie() {
			root = new Node();
		}

		public void addName(String s) {
			Node current = root;
			for (int i = 0; i < s.length(); i++) {
				if (current.children.containsKey(s.charAt(i))) {
					// Move to node and increment occurences
					current = current.children.get(s.charAt(i));
					current.occurences++;
				} else {
					// Make new node and update current
					Node newNode = new Node();
					current.children.put(s.charAt(i), newNode);
					current = newNode;
				}
			}
		}

		public int findPartial(String s) {
			Node current = root;
			for (int i = 0; i < s.length(); i++) {
				if (!current.children.containsKey(s.charAt(i))) {
					return 0; // Key not found
				} else {
					current = current.children.get(s.charAt(i));
				}
			}
			return current.occurences;
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int queriesRows = Integer.parseInt(scanner.nextLine().trim());

		String[][] queries = new String[queriesRows][2];

		for (int queriesRowItr = 0; queriesRowItr < queriesRows; queriesRowItr++) {
			String[] queriesRowItems = scanner.nextLine().split(" ");

			for (int queriesColumnItr = 0; queriesColumnItr < 2; queriesColumnItr++) {
				String queriesItem = queriesRowItems[queriesColumnItr];
				queries[queriesRowItr][queriesColumnItr] = queriesItem;
			}
		}

		int[] result = contacts(queries);

		for (int resultItr = 0; resultItr < result.length; resultItr++) {
			bufferedWriter.write(String.valueOf(result[resultItr]));

			if (resultItr != result.length - 1) {
				bufferedWriter.write("\n");
			}
		}

		bufferedWriter.newLine();

		bufferedWriter.close();
	}
}
