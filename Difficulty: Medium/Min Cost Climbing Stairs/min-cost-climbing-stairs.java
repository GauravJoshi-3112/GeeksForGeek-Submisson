//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int n = str.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            Solution sln = new Solution();
            int res = sln.minCostClimbingStairs(arr);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


//Back-end complete function Template for Java

class Solution {
    static int minCostClimb(int [] cost, int start) {
        int pprev = cost[start];
        int prev = cost[start+1] + pprev;
        int curr;
        for(int i = start+2; i<cost.length; i++) {
            curr = cost[i] + Math.min(prev,pprev);
            pprev = prev;
            prev = curr;
        }
        return Math.min(pprev,prev);
    }
    static int minCostClimbingStairs(int[] cost) {
        // To determine the min Cost to Climbing Stairs
        // Problem is with two starting point
        if (cost.length == 2) return  Math.min(cost[0],cost[1]);
        return Math.min(minCostClimb(cost, 0), minCostClimb(cost, 1));
    }
};