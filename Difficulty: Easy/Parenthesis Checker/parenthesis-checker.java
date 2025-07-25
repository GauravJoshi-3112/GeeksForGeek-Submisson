
class Solution {
    static boolean isBalanced(String s) {
        // code here
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            if (s.charAt(i) == ']' || s.charAt(i) == '}' || s.charAt(i) == ')') {
                if (stack.isEmpty() || stack.pop() != s.charAt(i)) return false;
            } else if (s.charAt(i) == '[') stack.push(']');
            else if (s.charAt(i) == '{') stack.push('}');
            else if (s.charAt(i) == '(') stack.push(')');
        }
        
        return stack.isEmpty();
    }
}
