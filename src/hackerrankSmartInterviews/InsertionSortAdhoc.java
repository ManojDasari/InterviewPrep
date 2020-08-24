package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InsertionSortAdhoc {

    public static void main(String[] args)throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine().trim());
        for(int i=0; i<testCases;i++){
            int count = Integer.parseInt(bufferedReader.readLine().trim());
            int[] input = new int[count];
            int j=0;
            for(String s: bufferedReader.readLine().trim().split(" ")){
                input[j]=Integer.parseInt(s);
                j++;
            }
            insertionSort(input,count);
            System.out.println();
        }
    }
    
    public static void insertionSort(int[] input, int N) {
        for (int i = 1; i < N ; i++) {
            int key=input[i];
            int j=i-1;
            while(j>=0&&input[j]>key){
                input[j+1]=input[j];
                j=j-1;
            }
            input[j+1]=key;
            System.out.print(j+1+" ");
        }
    }

}