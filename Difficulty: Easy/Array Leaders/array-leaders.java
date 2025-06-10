class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        // Will Maintain a Stack
        // Enters Smaller Element to Stack and Remove if Bigger ELement is found
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<arr.length; i++) {
            if (stack.isEmpty() || stack.peek() > arr[i]) {
                stack.push(arr[i]);
            } else {
                while((!stack.isEmpty()) && stack.peek() < arr[i]) {
                    stack.pop();
                }
                stack.push(arr[i]);
            }
        }
        
        return new ArrayList<>(stack);
    }
}
