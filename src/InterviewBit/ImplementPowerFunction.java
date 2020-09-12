package InterviewBit;

public class ImplementPowerFunction {
	public static int pow(int x, int n, int d) {
		if (x == 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		int check = 0;
		if (x < 0) {
			x = Math.abs(x);
			check = n % 2 != 0 ? 1 : 0;
		}
		long rem = 1;
		long temp = x % d;
		while (n != 0) {
			rem = n % 2 != 0 ? (rem * temp) % d : rem;
			temp = temp * temp;
			temp = temp % d;
			n /= 2;
			rem = rem % d;
		}
		return check == 1 ? d - (int) rem : (int) rem;
	}

	public static void main(String[] args) {
		System.out.println(-1 % 20);
		pow(-1, 1, 20);
	}
}
