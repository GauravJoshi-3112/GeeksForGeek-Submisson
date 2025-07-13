class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        // code here
        Arrays.sort(arr);
        int prev = -2;
        int lcs = 0;
        int sc = 0;
        
        for(int i=0; i<arr.length; i++) {
            if (arr[i] == prev) continue;
            else if (arr[i] == prev + 1) lcs = Math.max(++sc, lcs);
            else sc = 0;
            prev = arr[i];
        }
        
        return ++lcs;
    }
}