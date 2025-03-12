//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int [] dp;
    public int nthFibonacciDp(int n) {
        if (n == 0 || n == 1) return n;
        if (dp[n] != 0) return dp[n];
        int fib_1 = dp[n-1] != 0 ? dp[n-1] : nthFibonacciDp(n-1);
        int fib_2 = dp[n-2] != 0 ? dp[n-2] : nthFibonacciDp(n-2);
        return fib_1 + fib_2;
    }
    public int nthFibonacci(int n) {
        // Using Dynammic Programming To Solve Fibonnacci Problem
        dp = new int [n+1]; // Dp Array Need to be Populated with the answers
        return nthFibonacciDp(n);
    }
}