package InterviewBit;

public class MinChartoAddtmakeitPallindorme {

	public static int minChartoMakePallindrome(String str) {
		StringBuilder builder = new StringBuilder(str);
		String revStr = builder.reverse().toString();
		builder.reverse().append("$").append(revStr);

		int[] lpsArray = computeLPSArray(builder.toString());
		return str.length() - lpsArray[builder.length() - 1];
	}

	public static int[] computeLPSArray(String str) {
		int N = str.length();
		int[] lpsArr = new int[N];
		int i = 1, len = 0;
		lpsArr[0] = 0;
		while (i < N) {
			if (str.charAt(i) == str.charAt(len)) {
				len++;
				lpsArr[i] = len;
				i++;
			} else {
				if (len != 0) {
					len = lpsArr[len - 1];
				} else {
					lpsArr[i] = 0;
					i++;
				}
			}
		}
		return lpsArr;
	}

	public static void main(String args[]) {
		System.out.println(minChartoMakePallindrome("AACECAAAA"));
	}
}
