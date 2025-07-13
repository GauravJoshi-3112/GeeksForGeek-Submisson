class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        ArrayList<Integer> list = new ArrayList<>(Collections.nCopies(arr.length, -1));
        
        Stack<Integer> stack = new Stack<>();
        for(int i=arr.length-1; i>=0; i--) {
            while ((!stack.isEmpty()) && stack.peek() <= arr[i]) stack.pop();
            if (!stack.isEmpty()) list.set(i, stack.peek());
            stack.push(arr[i]);
        }
        
        return list;
    }
}