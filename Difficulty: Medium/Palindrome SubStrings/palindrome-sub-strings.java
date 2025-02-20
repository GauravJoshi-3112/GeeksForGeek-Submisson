//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();

            Solution obj = new Solution();

            System.out.println(obj.CountPs(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to Check Palindromic 
    public int CountPs(String s) {
        if (s == null || s.length() < 2) return 0;
        int count = 0;
        
        for (int center = 0; center < s.length(); center++) {
            // Count even-length palindromes (two adjacent centers)
            count += expandAroundCenter(s, center, center + 1);
            
            // Count odd-length palindromes (single center) but length >= 2
            count += expandAroundCenter(s, center, center + 2);
        }
        
        return count;
    }

    private int expandAroundCenter(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (right - left + 1 >= 2) { // Only count if length >= 2
                count++;
            }
            left--;
            right++;
        }
        return count;
    }

}