package FinalTestSI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SubStringDivision {

    public static void main(String[] args) throws IOException {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCases = Integer.parseInt(bufferedReader.readLine().trim());
        for (int i = 0; i < testCases; i++) {
            String input = bufferedReader.readLine().trim();
            String[] arr = bufferedReader.readLine().trim().split(" ");
            int N = Integer.parseInt(arr[0]);
            int K = Integer.parseInt(arr[1]);
            for(int j=0;j<N;j++){
                String[] array = bufferedReader.readLine().trim().split(" ");
                int x = Integer.parseInt(array[0]);
                int y = Integer.parseInt(array[1]);
                subDivision(input, x, y, K, bufferedWriter);
            }
        }
        bufferedWriter.flush();
    }

    public static void subDivision(String str, int i, int j, int K, BufferedWriter bw)throws IOException {
        int temp = Integer.valueOf(str.substring(i-1, j));
        if(temp%K==0){
            bw.write("Yes\n");    
        }else{
            bw.write("No\n");    
        }
        
    }

}