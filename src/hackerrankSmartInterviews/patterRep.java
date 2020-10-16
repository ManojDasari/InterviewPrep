package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class patterRep {
	static PriorityQueue<Integer> heap;

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			heap = new PriorityQueue<Integer>();
			String input = bufferedReader.readLine().trim();
			patternRepresentation(input, bufferedWriter);
		}
		bufferedWriter.flush();
	}

	public static void patternRepresentation(String input, BufferedWriter bw) throws IOException {
		bw.write(processString(input) + "\n");
	}

	private static String processString(String input) {
		String result = "";
		int len = input.length();
		for (int k = 1; k <= len + 1; k++)
			heap.add(k);
		int sCount = 0;
		int iCount = 0;
		for (int i = 0; i < len; i++) {
			if (input.charAt(i) == 'I') {
				sCount = getConsecutiveCount(input, i, 'I');
				result += getElement(sCount + 1);
				sCount = 0;
			} else {
				result += getElement(1);
				iCount = 0;
			}

		}
		return result + heap.poll();
	}

	public static int getConsecutiveCount(String input, int index, char ch) {
		int count = 0;
		for (int i = index; i < input.length(); i++) {
			if (input.charAt(i) == ch) {
				count++;
			} else {
				break;
			}
		}
		return count;
	}

	private static String getElement(int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int temp = 0, count = 0;
		while (k-- > 0) {
			temp = heap.poll();
			count++;
			if (k > 0) {
				pq.add(temp);
			} else {
				break;
			}
		}
		heap.addAll(pq);
		return temp + "";
	}

}