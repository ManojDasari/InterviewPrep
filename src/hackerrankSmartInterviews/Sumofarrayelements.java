package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sumofarrayelements {

    public static void main(String[] args)throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine().trim());
        for(int i=0;i<testCases;i++){
            int count = Integer.parseInt(bufferedReader.readLine().trim());
            long sum=0;
            String[] input = bufferedReader.readLine().trim().split(" ");
            for(int j=0;j<count;j++){
                sum=sum+Long.parseLong(input[j]);
            }
            System.out.println(sum);
        }
    }
}