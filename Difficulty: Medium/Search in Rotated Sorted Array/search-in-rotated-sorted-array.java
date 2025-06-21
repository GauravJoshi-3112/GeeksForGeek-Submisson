// User function Template for Java

class Solution {
    int search(int[] arr, int key) {
        // Complete this function
        int start = 0, end = arr.length - 1;
        
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (arr[mid] == key) return mid;
            
            if (arr[start] <= arr[mid]) {
                // Left Portion is Sorted
                if (key >= arr[start] && key < arr[mid]) end = mid - 1;
                else start = mid + 1;
            } else {
                // Right Portion is Sorted
                if (key > arr[mid] && key <= arr[end]) start = mid + 1;
                else end = mid - 1;
            }
        }
        
        return -1;
    }
}