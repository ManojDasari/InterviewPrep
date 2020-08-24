package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TowerofHanoiEasy {

    public static void main(String[] args)throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testcases = Integer.parseInt(bufferedReader.readLine().trim());
        for(int i=0;i<testcases; i++){
            int input = Integer.parseInt(bufferedReader.readLine());
            System.out.println((1<<input)-1);
            toh(input, 'A', 'C', 'B');
        }
    }
    
    public static void toh(int N, char A, char B, char C){
        if(N==0)
            return;
        toh(N-1, A, C, B);
        System.out.println("Move "+ N +" from "+ String.valueOf(A) +" to "+String.valueOf(B));
        toh(N-1, C, B, A);
    }
}