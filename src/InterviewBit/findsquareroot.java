package InterviewBit;

public class findsquareroot {
	public static int sqrt(int A) {
		if (A == 0)
			return 0;

		int start = 1, end = (int) 1e4;
		double mid = (start + end) / 2;
		while (start <= end) {
			mid = (start + end) / 2;
			int res = (int) Math.floor(mid * mid);
			if ((int) res == A)
				break;
			else if (res < A) {
				start = (int) mid + 1;
			} else
				end = (int) mid - 1;

		}
		return (int) mid;
	}

	public static void main(String[] args) {
		sqrt(5);
	}

}
