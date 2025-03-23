//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(new Solution().infixToPostfix(br.readLine().trim()));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String s) {
        // Creating a Map for Precedence 
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('(',0);
        map.put('+',1);
        map.put('-',1);
        map.put('*',2);
        map.put('/',2);
        map.put('^',3);
        map.put(')',-4);
        // Precedence Map is Completed
        
        Stack<Character> stack = new Stack<>(); // An Empty Stack for Operators
        
        StringBuilder result = new StringBuilder(""); // An Empty Expression as result
        
        // Traversing the input String
        for(int i=0; i<s.length(); i++) {
            // Check if Element is an Operand / Operator
            if (map.getOrDefault(s.charAt(i),-1) == -1) {
                // Its an Operand
                result.append(s.charAt(i));
            } else {
                char ch = s.charAt(i);
                if (stack.isEmpty() || ch == '(' ) {
                    stack.push(ch);
                } else if (ch == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        result.append(stack.pop());
                    }
                    stack.pop();
                } else {
                    while (!stack.isEmpty() && (map.getOrDefault(ch,-1) <= map.getOrDefault(stack.peek(),-1))) {
                        result.append(stack.pop());
                    }
                    stack.push(ch);
                }
            }
        }
        
        while (stack.size() != 0) {
             result.append(stack.pop());
        }
        
        return result.toString();
    }
}