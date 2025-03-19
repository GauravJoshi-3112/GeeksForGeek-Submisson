//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int[] arr = new int[s.length];
            for (int i = 0; i < s.length; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr));

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    
    int [][] dp;
    public int cutRod(int[] price) {
        // code here
        // Initializing Dp Array;
        int N = price.length;
        dp = new int[N+1][N+1];
        
        for(int i=0; i<N+1; i++) {
            dp[i][0] = 0;
        }
        
        for(int j=0; j<N+1; j++) {
            dp[0][j] = 0;
        }
        
        for(int i=1; i<N+1; i++) {
            for (int j=1; j<N+1; j++) {
                if (i >= j) {
                    // Valid case
                    // Two Case
                    dp[i][j] = Math.max(price[j-1] + dp[i-j][j], dp[i][j-1]);
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        
        return dp[N][N];
    }
}