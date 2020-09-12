package InterviewBit;

public class AmazingSubStrings {
	public static int solve(String A) {
		int mod = (int) 1e4 + 3;
		String vowles = "aeiouAEIOU";
		int result = 0;
		for (int i = 0; i < A.length(); i++) {
			if (vowles.indexOf(A.charAt(i)) != -1) {
				result = (result + A.length() - i) % mod;
			}
		}
		return result;
	}

	public static void main(String args[]) {
		System.out.println(solve(
				"pGpEusuCSWEaPOJmamlFAnIBgAJGtcJaMPFTLfUfkQKXeymydQsdWCTyEFjFgbSmknAmKYFHopWceEyCSumTyAFwhrLqQXbWnXSn"));
	}
}
