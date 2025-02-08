//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int m = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.nthRoot(n, m);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int getRootValue (int n, int value) {
        return (int) Math.pow(value, n);
    }
    public int nthRoot(int n, int m) {
        int start = 1, end = m;
        int mid = (start+end)/2;
        while (start<=end) {
            mid = (start+end)/2;
            int value = getRootValue(n,mid);
            if (value == m) return mid;
            if (value < m) start = mid+1;
            else end = mid-1;
        }
        return -1;
    }
}