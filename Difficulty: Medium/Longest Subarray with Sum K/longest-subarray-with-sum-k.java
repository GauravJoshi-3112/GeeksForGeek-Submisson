// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        HashMap<Integer,Integer> map = new HashMap<>();
        int longest = 0;
        int sum = 0;
        
        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
            if (sum == k) longest = Math.max(longest, i+1);
            if (map.containsKey(sum - k)) {
                longest = Math.max(longest, i - map.get(sum-k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        
        return longest;
    }
}
