class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        // code here
        String lps = s.substring(0, 1); // Longest Pallindromic Subsequence
        
        for(int index = 0; index < s.length(); index++) {
            int i = index;
            int j = index+1;
            
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            }
            
            if (lps.length() < (j - i - 1)) lps = s.substring(i+1, j);
            
            i = index - 1;
            j = index + 1;
            
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            }
            
            if (lps.length() < (j - i - 1)) lps = s.substring(i+1, j);
        }
        
        return lps;
    }
}