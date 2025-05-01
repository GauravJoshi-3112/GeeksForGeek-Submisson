//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total testcases
        int t = sc.nextInt();

        while (t-- > 0) {

            // taking count of stairs
            int m = sc.nextInt();

            // creating an object of class DynamicProgramming
            Solution obj = new Solution();

            // calling method countWays() of class
            // DynamicProgramming
            System.out.println(obj.countWays(m));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    int countWays(int n) {
        
        if (n <= 2) return n;
        // your code here
        // To Count number of ways to reach top without using any extra space
        int fn_stair = 2;
        int fn_1stair = 1;
        int fn_2stair = 0;
        
        for(int i=3; i<=n; i++) {
            fn_2stair = fn_1stair;
            fn_1stair = fn_stair;
            fn_stair = fn_2stair + fn_1stair;
        }
        
        return fn_stair;
    }
}
