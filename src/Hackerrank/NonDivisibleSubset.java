package Hackerrank;
/*
 * https://www.hackerrank.com/challenges/non-divisible-subset/problem
 * 
 */
import static java.util.stream.Collectors.toList;

/*
 * Given a set of distinct integers, print the size of a maximal subset of  where the sum of any  numbers in  is not evenly divisible by .

For example, the array  and . One of the arrays that can be created is . Another is . After testing all permutations, the maximum length solution array has  elements.

Function Description

Complete the nonDivisibleSubset function in the editor below. It should return an integer representing the length of the longest subset of  meeting the criteria.

nonDivisibleSubset has the following parameter(s):

S: an array of integers
k: an integer
Input Format

The first line contains  space-separated integers,  and , the number of values in  and the non factor.
The second line contains  space-separated integers describing , the unique values of the set.

Constraints

All of the given numbers are distinct.
Output Format

Print the size of the largest possible subset ().

Sample Input

4 3
1 7 2 4
Sample Output

3
Explanation

The sums of all permutations of two elements from  are:

1 + 7 = 8
1 + 2 = 3
1 + 4 = 5
7 + 2 = 9
7 + 4 = 11
2 + 4 = 6
We see that only  will not ever sum to a multiple of .
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    public static int nonDivisibleSubset(int k, List<Integer> s) {
    // Write your code here
        int[] count = new int[k];
        for (int i:s) 
            count[i % k]++; 
        if (k % 2 == 0) 
            count[k/2] = Math.min(count[k/2], 1);
        
        int res = Math.min(count[0], 1); 

        for (int i = 1; i <= k/2; i++) 
            res += Math.max(count[i], count[k-i]); 
      
        return res; 
        

    }

}

public class NonDivisibleSubset {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.nonDivisibleSubset(k, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
