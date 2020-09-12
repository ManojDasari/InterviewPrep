package Spoj;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class PRIMESTD {
	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		generatePrimes(100000001, bufferedWriter);
		bufferedWriter.flush();
	}

	public static void generatePrimes(int b, BufferedWriter bw) throws IOException {
		boolean[] primesArr = new boolean[b];
		Arrays.fill(primesArr, true);
		primesArr[0] = false;
		primesArr[1] = false;
		for (int i = 2; i * i <= b - 1; i++) {
			if (primesArr[i] == true) {
				int j = i * i;
				while (j <= b - 1) {
					primesArr[j] = false;
					j = j + i;
				}
			}
		}
		int count = 0;
		for (int i = 0; i < primesArr.length; i++) {
			if (primesArr[i]) {
				++count;
				if (count % 100 == 1)
					bw.write(String.valueOf(i) + '\n');
			}
		}
	}

}
