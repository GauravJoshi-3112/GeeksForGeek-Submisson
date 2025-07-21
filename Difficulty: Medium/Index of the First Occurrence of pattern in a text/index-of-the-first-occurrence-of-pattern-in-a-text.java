// User function Template for Java

class Solution {
    public int findMatching(String text, String pat) {
        // Code here
        if (pat.length() > text.length()) return -1;
        
        for(int i=0; i<= text.length() - pat.length(); i++) {
            if (text.substring(i, i+pat.length()).equals(pat)) return i;
        }
        
        return -1;
    }
}
