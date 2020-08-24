package hackerrankSmartInterviewBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Checkbit {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String[] array = bufferedReader.readLine().trim().split(" ");
		BigInteger input = new BigInteger(array[0]);
		int index = Integer.parseInt(array[1]);
		if (input.shiftRight(index).mod(BigInteger.valueOf(2)).equals(BigInteger.ONE))
			System.out.print(true);
		else
			System.out.print(false);
	}
}