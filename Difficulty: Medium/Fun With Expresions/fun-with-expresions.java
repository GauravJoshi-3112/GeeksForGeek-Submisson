//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.calculate(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    // Creating Two Stacks OperatorStack & OperandsStack
    Stack<String> operatorStack = new Stack<>();
    Stack<String> operandStack = new Stack<>();
    HashMap<String,Integer> priorityMap = new HashMap<>();
    
    public static int applyOperator(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b != 0) {
                    return a / b;
                } else {
                    throw new ArithmeticException("Division by zero!");
                }
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
    // Evaluating an Infix Expression
    public int calculate(String s)
    {
        // Created Priority Map for the operand's
        priorityMap.put("+",1);
        priorityMap.put("-",1);
        priorityMap.put("/",2);
        priorityMap.put("*",2);
        priorityMap.put("^",3);
        
        // Evaluating the String
        int start = 0, end = 0;
        while (end < s.length()) {
            while (end < s.length() && (!priorityMap.containsKey(s.substring(end,end+1)))) {
                end++;
            }
            if (start == end) end++;
            String exp = s.substring(start,end);
            if(!priorityMap.containsKey(exp)) operandStack.push(exp);
            else {
                if (operatorStack.isEmpty()) operatorStack.push(exp);
                else {
                    // Check for Priority Condition and then Evaluate
                    while ((!operatorStack.isEmpty()) && priorityMap.get(exp) <= priorityMap.get(operatorStack.peek())) {
                        // Evaluate the Expression
                        String op2 = operandStack.pop();
                        String op1 = operandStack.pop();
                        operandStack.push(Integer.toString(applyOperator(Integer.parseInt(op1),Integer.parseInt(op2),operatorStack.pop())));
                    } 
                    operatorStack.push(exp);
                }
            }
            start = end;
        }
        
        
        while (!operatorStack.isEmpty()) {
            // Evaluate the Expression
            String op2 = operandStack.pop();
            String op1 = operandStack.pop();
            operandStack.push(Integer.toString(applyOperator(Integer.parseInt(op1),Integer.parseInt(op2),operatorStack.pop())));
        } 
        
        return Integer.parseInt(operandStack.pop());
        
    }
}