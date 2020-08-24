package hackerrankSmartInterviewBasic;
/*
 * Given a matrix of size N x M. Print whether it is a sparse matrix. A matrix containing 0 value in more than half of its elements, then it is called a sparse matrix.

Input Format

First line of input contains N, M - size of the matrix. Its followed by N lines each containing M intergers - elements of the matrix.

Constraints

1 <= N, M <= 100
0 <= ar[i] <= 109

Output Format

Print "Yes" if given matrix is Sparse matrix, otherwise print "No".

Sample Input 0

2 3
5 0 0
0 8 0
Sample Output 0

Yes
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Asparsematrix {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String[] rowcol = bufferedReader.readLine().trim().split(" ");
		int row = Integer.parseInt(rowcol[0]);
		int col = Integer.parseInt(rowcol[1]);
		int size = row * col;
		BigInteger[][] input1 = new BigInteger[row][col];
		for (int i = 0; i < row; i++) {
			String[] inputStrints = bufferedReader.readLine().trim().split(" ");
			for (int j = 0; j < col; j++) {
				input1[i][j] = new BigInteger(inputStrints[j]);
			}
		}
		int count = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (input1[i][j].equals(BigInteger.ZERO))
					count += 1;
			}
		}
		if (count > (size / 2))
			System.out.print("Yes");
		else
			System.out.print("No");
	}
}