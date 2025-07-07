class Solution {
    public int maxConsecBits(int[] arr) {
        // code here
        int prev = -1;
        int maxCount = 0;
        int count = 0;
        
        for(int elem : arr) {
            if (prev == elem) count++;
            else {
                prev = elem;
                count = 1;
            }
            maxCount = Math.max(maxCount, count);
        }
        
        return maxCount;
    }
}
