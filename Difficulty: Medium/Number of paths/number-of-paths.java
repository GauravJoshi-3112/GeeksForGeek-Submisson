//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int m = Integer.parseInt(read.readLine());
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.numberOfPaths(m, n));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    int [][] dp;
    public int numberOfPaths(int m, int n) {
        // Code Here
        dp = new int[m][n];
        // Initialize the dp Array
        for(int i=0; i<m; i++) {
            dp[i][0] = 1;
        }
        
        for(int j=0; j<n; j++) {
            dp[0][j] = 1;
        }
        
        // Once initialization is done calculate
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        
        return dp[m-1][n-1];
        
    }
}