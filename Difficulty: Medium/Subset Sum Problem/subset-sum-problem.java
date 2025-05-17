//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int N = input_line.length;
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isSubsetSum(arr, sum))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    

    static Boolean isSubsetSum(int arr[], int sum) {
        boolean dp [][] = new boolean[arr.length+1][sum+1];
        
        // Initializing 
        // Sum 0 can be formed by every possible case (Empty Subset)
        for(int i=0; i<=arr.length; i++) dp[i][0] = true;
        
        // Traversing and Calculating
        for(int i=1; i<=arr.length; i++) {
            for(int j=1; j<=sum; j++) {
                if (arr[i-1] <= j) {
                    // Need Choice Diagram
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[arr.length][sum];
        
    }
}