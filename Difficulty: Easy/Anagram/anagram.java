class Solution {
    public static boolean areAnagrams(String s1, String s2) {
        // code here
        if (s1.length() != s2.length()) return false;
        
        // Create freq array
        int [] charFreq = new int[26];
        
        // Traverse Both Array Simulatneously
        for(int i=0; i<s1.length(); i++) {
            charFreq[s1.charAt(i) - 'a'] += 1;
            charFreq[s2.charAt(i) - 'a'] -= 1;
        }
        
        
        for(int elem : charFreq) {
            if (elem != 0) return false;
        }
        
        return true;
    }
}