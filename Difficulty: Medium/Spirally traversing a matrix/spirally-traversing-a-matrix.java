class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int matrix[][]) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        
        while (top <= bottom && left <= right) {
            for(int i=left; i<=right; i++) {
                list.add(matrix[top][i]);
            }
            top++;
            
            for(int j=top; j<=bottom; j++) {
                list.add(matrix[j][right]);
            }
            right--;
            
            // 3. Right to Left on bottom row (only if still valid)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }
    
            // 4. Bottom to Top on left column (only if still valid)
            if (left <= right) {
                for (int j = bottom; j >= top; j--) {
                    list.add(matrix[j][left]);
                }
                left++;
            }

        }
        
        return list;
    }
}
