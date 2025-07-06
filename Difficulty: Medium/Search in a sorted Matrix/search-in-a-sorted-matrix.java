

class Solution {
    // Function to search a given number in row-column sorted matrix.
    public boolean searchMatrix(int[][] mat, int x) {
        // code here
        // Perform Binary Search
        int row = mat.length;
        int col = mat[0].length;
        
        int start = 0;
        int end = row*col - 1;
        
        while (start <= end) {
            int mid = start + (end - start)/2;
            
            int midrow = mid/col;
            int midcol = mid%col;
            
            if (mat[midrow][midcol] == x) return true;
            else if (mat[midrow][midcol] > x) end = mid - 1;
            else start = mid + 1;
        }
        
        return false;
        
    }
}
