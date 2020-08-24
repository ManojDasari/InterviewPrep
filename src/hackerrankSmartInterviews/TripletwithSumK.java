package hackerrankSmartInterviews;
/*
 * You are given an integer array and a number K. You have to tell if there exists i,j,k in the given array such that ar[i]+ar[j]+ar[k]=K, i≠j≠k.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines, the first line contains N and K - the size of the array and the number K. The second line contains the elements of the array.

Constraints

30 points
1 <= T <= 100
3 <= N <= 100

70 points
1 <= T <= 100
3 <= N <= 1000

General
-100000 <= A[i] <= 100000
0 <= K <= 100000

Output Format

For each test case, print "true" if the arrays contains such elements, false otherwise, separated by new line.

Sample Input 0

3
5 60
1 20 40 100 80 
12 54
12 45 52 65 21 645 234 -100 14 575 -80 112 
3 15
5 5 5
Sample Output 0

false
true
true
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TripletwithSumK {

    public static void main(String[] args)throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine().trim());
        for(int i=0;i<testCases;i++){
            String[] lengthandSumValues = bufferedReader.readLine().trim().split(" ");
            int count = Integer.parseInt(lengthandSumValues[0]);
            int sum = Integer.parseInt(lengthandSumValues[1]);
            String[] array = bufferedReader.readLine().trim().split(" ");
            int[] input = new int[count];
            for(int j=0;j<count;j++){
                input[j]=Integer.parseInt(array[j]);
            }
            Arrays.sort(input);
            checkSumPairs(input,count-1, sum);
        }
    }
    
    public static void checkSumPairs(int[] input, int count, int sum) {
        for (int i = 0; i < count - 1; i++) {
            int p1 = i + 1, p2 = count;
            while (p1 < p2) {
                if (input[p1] + input[p2] + input[i] == sum) {
                    System.out.println("true");
                    return;
                } else if (input[p1] + input[p2] + input[i] < sum)
                    p1++;
                else
                    p2--;
            }
        }
        System.out.println("false");
    }
}