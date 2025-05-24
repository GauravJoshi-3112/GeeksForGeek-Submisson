//Back-end complete function Template for Java
class Solution {
    public void setMatrixZeroes(int[][] mat) {
        boolean row0 = false, col0 = false;
        // traverse the 0th Row & 0th Col
        for(int i=0; i<mat.length; i++) {
            if (mat[i][0] == 0) {
                col0 = true;
                break;
            }
        }
        
        for(int j=0; j<mat[0].length; j++) {
            if (mat[0][j] == 0) {
                row0 = true;
                break;
            }
        }
        
        // Traverse Array
        for(int i=1; i<mat.length; i++) {
            for(int j=1; j<mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    mat[i][0] = 0;
                    mat[0][j] = 0;
                }
            }
        }
        
        // Implementing Logic
        for(int i=1; i<mat.length; i++) {
            for(int j=1; j<mat[0].length; j++) {
                if (mat[i][0] == 0 || mat[0][j] == 0) mat[i][j] = 0;
            }
        }
        
        if (row0) {
            for(int j=0; j<mat[0].length; j++) {
                mat[0][j] = 0;
            }
        }
        
        if (col0) {
            for(int i=0; i<mat.length; i++) {
                mat[i][0] = 0;
            }
        }
        
        return;
    }
}