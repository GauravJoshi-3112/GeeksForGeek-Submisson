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
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        int longestSubstr = -1;
        // Maintain a HashMap for Windows
        HashMap<Character,Integer> window = new HashMap<>();
        int i = 0, j = 0; // Maintain Pointers
        while (j < s.length()) { // Till J Crosses String 
            // Step 1 // Increase the window
            while (j < s.length() && window.size() <= k) {
                if (window.size() == k && !window.containsKey(s.charAt(j))) {
                    // Yaha se mera tutega
                    break;
                }
                window.put(s.charAt(j),window.getOrDefault(s.charAt(j),0) + 1);
                j++;
            }
            
            // Step 2 // Calculation
            if (window.size() == k) {
                if (j- i > longestSubstr) longestSubstr = j - i;
            }
            
            // Step 3 // Decrease the window
            while(!(window.size() < k)) {
                // Increase i till window is again reduced back to < k
                if (window.get(s.charAt(i)) == 1) window.remove(s.charAt(i));
                else window.put(s.charAt(i),window.get(s.charAt(i)) - 1);
                i++;
            }
        }
        
        return longestSubstr;
    }
}