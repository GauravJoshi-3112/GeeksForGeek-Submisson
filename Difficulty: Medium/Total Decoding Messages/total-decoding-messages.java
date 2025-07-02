// User function Template for Java
class Solution {
    int [] dp;
    // Using recursion and memoization
    public int countWays(String digits) {
        dp = new int[digits.length()+1];
        dp[digits.length()] = 1;
        
        for(int i=digits.length() - 1; i >= 0; i--) {
        	if (digits.charAt(i) == '0') dp[i] = 0;
        	else if (i + 2 < dp.length && Integer.valueOf(digits.substring(i,i+2)) <= 26) dp[i] = dp[i+1] + dp[i+2];
        	else dp[i] = dp[i+1];
        }
        
        return dp[0];
    }
}