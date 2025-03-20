//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int dp [][];
    public int longestCommonSubstr(String s1, String s2) {
        // Initialization of DP Array
        dp = new int[s1.length()+1][s2.length()+1];
        for(int i=0; i<s1.length()+1; i++) {
            dp[i][0] = 0;
        }
        for(int j=0; j<s2.length()+1; j++) {
            dp[0][j] = 0;
        }
        for(int i=1; i<s1.length()+1; i++) {
            for(int j=1; j<s2.length()+1; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else {
                    dp[i][j] = 0;
                }
            }
        }
        int max = 0;
        for(int i=1; i<s1.length()+1; i++) {
            for(int j=1; j<s2.length()+1; j++) {
               if (dp[i][j] > max) max = dp[i][j];
            }
        }
        
        return max;
    }
}