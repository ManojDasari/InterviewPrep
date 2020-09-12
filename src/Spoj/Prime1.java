package Spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * Peter wants to generate some prime numbers for his cryptosystem. Help him! Your task is to generate all prime numbers between two given numbers!

Input
The input begins with the number t of test cases in a single line (t<=10). In each of the next t lines there are two numbers m and n (1 <= m <= n <= 1000000000, n-m<=100000) separated by a space.

Output
For every test case print all prime numbers p such that m <= p <= n, one number per line, test cases separated by an empty line.

Example
Input:
2
1 10
3 5

Output:
2
3
5
7

3
5
 */
public class Prime1 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		ArrayList<Integer> primes = generatePrimes(1000002);
		for (int i = 0; i < testCases; i++) {
			String[] array = bufferedReader.readLine().trim().split(" ");
			int a = Integer.parseInt(array[0]);
			int b = Integer.parseInt(array[1]);
			printPrimesinRange(a, b, primes);
		}
	}

	public static void printPrimesinRange(int a, int b, ArrayList<Integer> list) {
		if (a < 2)
			a = 2;
		boolean[] primes = new boolean[(int) (b - a + 1)];
		Arrays.fill(primes, true);
		for (int i = 0; list.get(i) * list.get(i) <= b; i++) {
			int p = list.get(i);
			int j;
			if (p >= a)
				j = p * 2;
			else
				j = (int) (a + ((p - a % p) % p));

			while (j <= b) {
				primes[(int) (j - a)] = false;
				j = j + p;
			}
		}
		for (int i = a; i <= b; i++) {
			if (primes[i - a])
				System.out.println(i);
		}

	}

	public static ArrayList<Integer> generatePrimes(int b) {
		boolean[] primesArr = new boolean[b];
		ArrayList<Integer> primes = new ArrayList<Integer>();
		Arrays.fill(primesArr, true);
		primesArr[0] = false;
		primesArr[1] = false;
		for (int i = 2; i * i <= 100000; i++) {
			if (primesArr[i] == true) {
				int j = i * i;
				while (j <= 100000) {
					primesArr[j] = false;
					j = j + i;
				}
			}
		}
		for (int i = 0, j = 0; i < primesArr.length; i++) {
			if (primesArr[i]) {
				primes.add(j++, i);
			}
		}
		return primes;
	}
}
