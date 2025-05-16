//{ Driver Code Starts
import java.util.*;

class Get_Min_From_Stack {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Number of test cases

        while (T-- > 0) {
            int q = sc.nextInt(); // Number of queries
            Solution g = new Solution();

            while (q-- > 0) {
                int qt = sc.nextInt();

                if (qt == 1) {
                    int att = sc.nextInt();
                    g.push(att);
                } else if (qt == 2) {
                    g.pop(); // Just call pop(), do not print anything
                } else if (qt == 3) {
                    System.out.print(g.peek() + " "); // Print top element
                } else if (qt == 4) {
                    System.out.print(g.getMax() + " "); // Print minimum element
                }
            }
            System.out.println("\n~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    Stack<Integer> maxStack;
    Stack<Integer> prmStack;
    public Solution() {
        maxStack = new Stack<>();
        prmStack = new Stack<>();
    }

    // Add an element to the top of Stack
    public void push(int x) {
        // code here
        if (maxStack.isEmpty() || x > maxStack.peek()) {
            maxStack.push(x);
        }
        prmStack.push(x);
    }

    // Remove the top element from the Stack
    public void pop() {
        // code here
        if (prmStack.isEmpty()) return;
        else if(prmStack.pop().equals(maxStack.peek())) maxStack.pop();
    }

    // Returns top element of the Stack
        
    public int peek() {
        // code here
        return prmStack.isEmpty() ? -1 : prmStack.peek();
    }

        
    // Finds minimum element of Stack
    public int getMax() {
        // code here
        return maxStack.isEmpty() ? -1 : maxStack.peek();
    }
}