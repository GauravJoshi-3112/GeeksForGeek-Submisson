//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int a;
            a = Integer.parseInt(br.readLine());

            int b;
            b = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            int[] ans = obj.lcmAndGcd(a, b);
            System.out.println(ans[0] + " " + ans[1]);
            System.out.println("~");
        }
    }
}


// } Driver Code Ends

// User function Template for Java

class Solution {
    public static int getGcd (int div, int num){
        if (num%div==0){
            return div;
        }
        return getGcd(num%div,div);
    }
    public static int[] lcmAndGcd(int a, int b) {
        // code here
        int lcm = 1, gcd = 1;
        gcd = getGcd(Math.min(a,b),Math.max(a,b));
        lcm = (a*b)/gcd;
        return new int [] {lcm, gcd};
    }
}

//{ Driver Code Starts.

// } Driver Code Ends