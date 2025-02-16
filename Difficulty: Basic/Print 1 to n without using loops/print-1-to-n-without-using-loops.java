//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			
            Solution ob = new Solution();
            ob.printTillN(N);
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static void printTillN(int N){
        // Base Case
        if (N <= 1) {
            if (N == 1) System.out.print(1 + " ");
            return;
        }
        // Recursion Faith for Sub Problem
        printTillN(N-1);
        
        // Operation for N;
        System.out.print(N + " ");
    }
}