package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RotationofMatrix {

    public static void main(String[] args)throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine().trim());
        for(int i=0;i<testCases;i++){
            int size = Integer.parseInt(bufferedReader.readLine().trim());
            int[][] input = new int[size][size];
            System.out.println("Test Case #"+(i+1)+":");
            for(int j=0;j<size;j++){
                String[] array = bufferedReader.readLine().trim().split(" ");
                for(int k=0;k<size;k++){
                    input[j][k] = Integer.parseInt(array[k]);
                }
            }
            rotateMatrix(input, size);
        }
    }
    
    public static void rotateMatrix(int[][] a, int N){
        for (int i = 0; i < N / 2; i++) { 
            for (int j = i; j < N - i - 1; j++) { 
                int temp = a[i][j]; 
                a[i][j] = a[N - 1 - j][i]; 
                a[N - 1 - j][i] = a[N - 1 - i][N - 1 - j]; 
                a[N - 1 - i][N - 1 - j] = a[j][N - 1 - i]; 
                a[j][N - 1 - i] = temp; 
            } 
        }
        
        for(int i=0;i<N;i++){              
            for(int j=0;j<N;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println("");
        }
    }
}