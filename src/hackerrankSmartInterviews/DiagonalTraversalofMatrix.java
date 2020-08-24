package hackerrankSmartInterviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DiagonalTraversalofMatrix {

    public static void main(String[] args)throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine().trim());
        for(int i=0;i<testCases;i++){
            int size = Integer.parseInt(bufferedReader.readLine().trim());
            int[][] input = new int[size][size];
            for(int j=0;j<size;j++){
                String[] array = bufferedReader.readLine().trim().split(" ");
                for(int k=0;k<size;k++){
                    input[j][k] = Integer.parseInt(array[k]);
                }
            }
            diagonalSum(input, size);
            System.out.println("");
        }
    }
    
    public static void diagonalSum(int[][] input, int N) {
        int row = 0, col = N - 1;
        while (col >= 0) {
            int sum = 0;
            for (int i = row, j = col; i < N && j < N; i++, j++) {
                sum += input[i][j];
            }
            System.out.print(sum + " ");
            col--;
        }
        row = 1;
        col = 0;
        while (row < N) {
            int sum = 0;
            for (int i = row, j = col; i < N; i++, j++) {
                sum += input[i][j];
            }
            System.out.print(sum + " ");
            row++;
        }
    }
}