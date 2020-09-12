package Hackerrank;

/*
 * Two players called  and  are playing a game with a starting number of stones. Player  always plays first, and the two players move in alternating turns. The game's rules are as follows:

In a single move, a player can remove either , , or  stones from the game board.
If a player is unable to make a move, that player loses the game.
Given the starting number of stones, find and print the name of the winner.  is named First and  is named Second. Each player plays optimally, meaning they will not make a move that causes them to lose the game if a winning move exists.

For example, if ,  can make the following moves:

 removes  stones leaving .  will then remove  stones and win.
 removes  stones leaving .  cannot move and loses.
 would make the second play and win the game.

Function Description

Complete the gameOfStones function in the editor below. It should return a string, either First or Second.

gameOfStones has the following parameter(s):

n: an integer that represents the starting number of stones
Input Format

The first line contains an integer , the number of test cases.
Each of the next  lines contains an integer , the number of stones in a test case.

Constraints

Output Format

On a new line for each test case, print First if the first player is the winner. Otherwise print Second.

Sample Input

8
1
2
3
4
5
6
7
10
Sample Output

Second
First
First
First
First
First
Second
First
Explanation
 */
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class gameOfStones {
	static final int LIMIT = 100;
	static final int[] STONES_IN_ONE_MOVE = { 2, 3, 5 };

	// Complete the gameOfStones function below.
	static String gameOfStones(int n) {
		boolean[] gameTable = buildGametable();
		return gameTable[n] ? "First" : "Second";
	}

	static boolean[] buildGametable() {
		boolean[] gameTable = new boolean[LIMIT + 1];
		for (int i = 0; i < gameTable.length; i++) {
			for (int stone : STONES_IN_ONE_MOVE) {
				if (i >= stone && !gameTable[i - stone]) {
					gameTable[i] = true;
					break;
				}
			}
		}
		return gameTable;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			String result = gameOfStones(n);

			bufferedWriter.write(result);
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}
