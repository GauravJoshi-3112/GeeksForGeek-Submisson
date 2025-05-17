//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    
    BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
    String homepage=bu.readLine();
    BrowserHistory obj=new BrowserHistory(homepage);
    int total_queries=Integer.parseInt(bu.readLine());
    while(total_queries-->0)
     {
         String s[]=bu.readLine().split(" ");
         int query=Integer.parseInt(s[0]);
          if(query == 1) {
            String url=s[1];
            obj.visit(url);
        }
        else if(query == 2) {
            int steps=Integer.parseInt(s[1]);
            System.out.println(obj.back(steps));
        }
        else {
            int steps=Integer.parseInt(s[1]);
            System.out.println(obj.forward(steps));
        }
     }
  }
}
// } Driver Code Ends


// User function Template for Java

class BrowserHistory {
    
    Stack<String> fwdStack;
    Stack<String> bwdStack;
    // constructor to initialize object with homepage
    BrowserHistory(String homepage) {
        fwdStack = new Stack<>();
        bwdStack = new Stack<>();
        fwdStack.push(homepage);
    }

    // visit current url
    void visit(String url) {
        if (!bwdStack.isEmpty()) bwdStack.clear();
        fwdStack.push(url);
    }

    // 'steps' move backward in history and return current page
    String back(int steps) {
        while (steps > 0 && fwdStack.size() > 1) {
            bwdStack.push(fwdStack.pop());
            steps--;
        }
        return fwdStack.peek();
    }

    // 'steps' move forward and return current page
    String forward(int steps) {
        while (steps > 0 && !bwdStack.isEmpty()) {
            fwdStack.push(bwdStack.pop());
            steps--;
        }
        return fwdStack.peek();
    }
}