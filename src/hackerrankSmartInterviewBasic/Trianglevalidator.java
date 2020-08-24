package hackerrankSmartInterviewBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Trianglevalidator {

    public static void main(String[] args)throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = bufferedReader.readLine().trim().split(" ");
        int a = Integer.parseUnsignedInt(array[0]);
        int b = Integer.parseUnsignedInt(array[1]);
        int c = Integer.parseUnsignedInt(array[2]);
        if(a+b>c && a+c>b && b+c>a)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}