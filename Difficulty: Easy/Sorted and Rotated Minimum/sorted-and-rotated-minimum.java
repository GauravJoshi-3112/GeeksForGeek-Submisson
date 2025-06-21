// User function Template for Java

class Solution {
    public int findMin(int[] arr) {
        // complete the function here
        int start = 0, end = arr.length - 1;
        int minElem = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = start + (end - start)/2;
            minElem = Math.min(minElem,arr[mid]);
            
            // Find the Sorted half
            if (arr[start] <= arr[mid]) {
                // Left Part is Sorted
                minElem = Math.min(minElem,arr[start]);
                start = mid + 1;
            } else {
                // Right Part is Sorted
                minElem = Math.min(minElem,arr[mid]);
                end = mid - 1;
            }
        }
        
        return minElem;
    }
}
