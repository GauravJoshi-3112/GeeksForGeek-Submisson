class Solution {
    int [] dp;
    public int findMaxSumHelp(int arr[], int index) {
        if (index >= arr.length) return 0;
        if (index < arr.length && dp[index] != 0) return dp[index];
        
        dp[index] = Math.max(findMaxSumHelp(arr,index+1),findMaxSumHelp(arr,index+2)+arr[index]);
        return dp[index]; 
    }
    public int findMaxSum(int arr[]) {
        dp = new int[arr.length];
        return findMaxSumHelp(arr, 0);
    }
}