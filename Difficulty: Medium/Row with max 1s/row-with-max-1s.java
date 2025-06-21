// User function Template for Java

class Solution {
    public int rowWithMax1s(int arr[][]) {
        // code here
        int maxCount = 0;
        int maxIndex = -1;
        
        // Traverse the Matrix
        for(int i=0; i<arr.length; i++) {
            int start = 0, end = arr[i].length - 1;
            int mid = 0;
            int index = arr[i].length;
            while(start <= end) {
                mid = start + (end - start)/2;
                
                if (arr[i][mid] == 1) {
                    index = Math.min(index,mid);
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            
            if (arr[i].length - index > maxCount) {
                maxCount = arr[i].length - index;
                maxIndex= i;
            }
        }
        
        return maxIndex;
    }
}