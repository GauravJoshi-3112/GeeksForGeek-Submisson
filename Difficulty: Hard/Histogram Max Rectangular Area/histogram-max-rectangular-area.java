class Solution {
    public static int getMaxArea(int arr[]) {
        int n = arr.length;
        int[] nextMinArr = new int[n];
        int[] prevMinArr = new int[n];
    
        Stack<Integer> stack = new Stack<>();
    
        // Find Next Smaller
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            nextMinArr[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
    
        stack.clear();
    
        // Find Previous Smaller
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            prevMinArr[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
    
        // Calculate Max Area
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = nextMinArr[i] - prevMinArr[i] - 1;
            int area = arr[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        
        return maxArea;
    }
}
