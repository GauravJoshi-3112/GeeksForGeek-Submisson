//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubstr(s));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestUniqueSubstr(String s) {
        // In this case we will be using hashset
        int [] charArray = new int [26];
        
        int longestLength = 0;
        
        int i = 0, j = 0;  // Initialize two pointer's to 0
        while (j < s.length()) {
            while (j < s.length() && charArray[s.charAt(j)-97] == 0) {
                charArray[s.charAt(j)-97] = 1;
                j++;
            }
            
            if (j-i > longestLength) longestLength = j-i;
            
            while (j < s.length() && i<j && charArray[s.charAt(j)-97] != 0) {
                charArray[s.charAt(i)-97] = 0;
                i++;
            }
        }
        
        return longestLength;
    }
}