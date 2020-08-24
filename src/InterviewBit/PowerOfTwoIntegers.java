package InterviewBit;

/*
 * Given a positive integer which fits in a 32 bit signed integer, find if it can be expressed as A^P where P > 1 and A > 0. A and P both should be integers.

Example

Input : 4
Output : True  
as 2^2 = 4. 
 */
public class PowerOfTwoIntegers {

	public int isPower(int A) {
		if (A == 1)
			return 1;
		int p = 2;
		int a = 2;
		boolean flag = false;

		while (true) {
			p = 2;
			while (true) {
				if (Math.pow(a, p) == A) {
					flag = true;
					break;
				} else if (Math.pow(a, p) > A) {
					break;
				}
				p++;
			}

			a++;
			if (flag)
				break;
			else if (a > A) {
				break;
			}
		}

		return flag ? 1 : 0;
	}

}
