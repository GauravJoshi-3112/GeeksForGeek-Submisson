//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String temp[] = sc.nextLine().trim().split(" ");
            int n = temp.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(temp[i]);
            Solution ob = new Solution();
            System.out.println(ob.maxSumIS(arr));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int dp [][];
    public int maxSumIS(int arr[]) {
        //To get the Max Sum Increasing Subsequence (Subsequence in Sorted Order)
        int [] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        
        // After Sorting the Array Find LCS for both Orignal and Sorted Array
        dp = new int[arr.length+1][sortedArr.length+1];
        
        // Using top Down Manner
        for(int i=1; i<arr.length+1; i++) {
            for(int j=1; j<sortedArr.length+1; j++) {
                if (j != 1 && sortedArr[j-1] == sortedArr[j-2]) {
                    dp[i][j] = dp[i][j-1];
                }
                else if (arr[i-1] == sortedArr[j-1]) {
                    // If Element are Equal can be Part of Increasing Subsequence
                    dp[i][j] = dp[i-1][j-1] + arr[i-1];
                } else {
                    // Get max of Subsequences
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[arr.length][sortedArr.length];
        
    }
}