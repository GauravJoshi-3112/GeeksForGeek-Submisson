// User function Template for Java

class Solution {
    public int totalWays(int N, int M, int grid[][]) {
        // Code here
        int dp [][] = new int [N][M];
        
        // Initialize dp array
        for(int i=0; i<N; i++) {
            if (grid[i][0] == 1) break;
            dp[i][0] = 1;
        }
        
        // Initialize dp array
        for(int j=0; j<M; j++) {
            if (grid[0][j] == 1) break;
            dp[0][j] = 1;
        }
        
        
        // Process
        for(int i=1; i<N; i++) {
            for(int j=1; j<M; j++) {
                if (grid[i][j] == 1) dp[i][j] = 0;
                else dp[i][j] = (dp[i-1][j] + dp[i][j-1])%1000000007;
            }
        }
        
        return dp[N-1][M-1];
    }
}