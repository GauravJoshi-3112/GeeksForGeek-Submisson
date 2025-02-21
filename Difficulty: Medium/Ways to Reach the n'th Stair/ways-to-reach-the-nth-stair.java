//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total testcases
        int t = sc.nextInt();

        while (t-- > 0) {

            // taking count of stairs
            int m = sc.nextInt();

            // creating an object of class DynamicProgramming
            Solution obj = new Solution();

            // calling method countWays() of class
            // DynamicProgramming
            System.out.println(obj.countWays(m));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to Count number of ways to reach from ith Stair to nth Stair
    public int [] arr = null;
    
    int countWays(int curr, int n) {
        if (curr >= n) return 0;
        else if (curr+1 == n) return 1;
        else if (curr+2 == n) return 2;
        int left_ways = 0;
        int right_ways = 0;
        if (arr[curr+1] != 0) left_ways = arr[curr+1];
        else {
            left_ways = countWays(curr+1,n);
            arr[curr+1] = left_ways;
        }
        if (arr[curr+2] != 0) right_ways = arr[curr+2];
        else {
            right_ways = countWays(curr+2,n);
            arr[curr+2] = right_ways;
        }
        return left_ways + right_ways;
    }
    // Function to count number of ways to reach the nth stair.
    int countWays(int n) {
        arr = new int[n];
        // your code here
        return countWays(0,n);
    }
}
