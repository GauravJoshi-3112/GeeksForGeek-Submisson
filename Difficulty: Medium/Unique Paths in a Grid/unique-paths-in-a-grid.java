//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            
            int [][] grid = new int[n][m];
            for(int i=0; i<n; i++)
            {
                String S1[] = read.readLine().split(" ");
                for(int j=0; j<m; j++)
                {
                    grid[i][j] = Integer.parseInt(S1[j]);
                }
            }

            Solution ob = new Solution();
            System.out.println(ob.uniquePaths(n,m,grid));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int uniquePaths(int n, int m, int[][] grid) {
        // code here
        int [][] dp = new int [n][m];
        int mod = 1000000007;
        
        dp[0][0] = grid[0][0];
        
        // initialization of dp array
        for(int i=1; i<n; i++) {
            if (grid[i][0] != 0 && dp[i-1][0] != 0) dp[i][0] = 1;
            else dp[i][0] = 0; // Its an Obstacle no way to reach here
        }
        
        for(int j=1; j<m; j++) {
            if (grid[0][j] != 0 && dp[0][j-1] != 0) dp[0][j] = 1;
            else dp[0][j] = 0; // Its an Obstacle no way to reach here
        }
        
        for(int i=1; i<n; i++) {
            for(int j=1; j<m; j++) {
                if (grid[i][j] != 0) dp[i][j] = (int)((dp[i-1][j] + dp[i][j-1]) % mod);
                else dp[i][j] = 0; // Its an Obstacle no way to reach here
            }
        }
        
        return (int)(dp[n-1][m-1] % 1000000007);
    }
};