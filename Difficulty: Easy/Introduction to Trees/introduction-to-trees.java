//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();

            Solution obj = new Solution();
            int ans = obj.countNodes(n);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int countNodes(int i) {
        // We Simply Need To print What are the Number of Nodes That could be Present at a Particular Level
        return (int)(Math.pow(2,i-1));
    }
}