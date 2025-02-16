//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int n = str.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            new Solution().printArray(arr);
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    void printArray(int index, int arr[]) {
        if (index >= arr.length) return ;
        System.out.print(arr[index] + " ");
        printArray(index+1,arr);
    }
    // Just print the space seperated array elements
    void printArray(int arr[]) {
        // Base Case
        printArray(0, arr); // Using Array help Function (Method Overloading)
    }
}