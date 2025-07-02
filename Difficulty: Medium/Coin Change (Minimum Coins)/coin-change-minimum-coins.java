class Solution {

    int [][] dp;
    public int minCoins(int coins[], int sum) {
        // code here
        dp = new int [coins.length+1][sum+1];
        
        // Initialize DP Array
        for(int i=0; i<=coins.length; i++) {
            dp[i][0] = 0;
        }
        
        // Initialize DP Array
        for(int j=0; j<=sum; j++) {
            dp[0][j] = Integer.MAX_VALUE - 1;
        }
        
        for(int i=1; i<=coins.length; i++) {
            for(int j=1; j<=sum; j++) {
                if (coins[i-1] > j) {
                    // Cannot take Coin
                    dp[i][j] = dp[i-1][j];
                } else {
                    // Can Take Coin or Cannot
                    dp[i][j] = Math.min(dp[i][j - coins[i-1]] + 1, dp[i-1][j]);
                }
            }
        }
        
        
        return dp[coins.length][sum] == Integer.MAX_VALUE - 1 ? -1 : dp[coins.length][sum];
    }
}