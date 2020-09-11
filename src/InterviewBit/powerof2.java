package InterviewBit;

import java.math.BigInteger;

public class powerof2 {
    public static int power(String A) {
        BigInteger input = new BigInteger(A);
        if(input.compareTo(BigInteger.ONE)==0 || input.compareTo(BigInteger.ZERO)==0)
            return 0;
        BigInteger temp = input.subtract(BigInteger.ONE);
        if(input.and(temp).equals(BigInteger.ZERO))
        	return 1;
        else
        	return 0;
    }
    
    public static void main(String args[]) {
		System.out.println(power("122"));
	}
}
