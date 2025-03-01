//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Driver_code {
    static Node insert(Node head, int data) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
            return head;
        } else {
            Node t = head;
            while (t.next != null) {
                t = t.next;
            }
            t.next = temp;
        }
        return head;
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            Node head = null;

            String str[] = read.readLine().trim().split(" ");
            int listSize = str.length;
            for (int i = 0; i < listSize; i++) {
                head = insert(head, Integer.parseInt(str[i]));
            }
            boolean f = new Solution().isPalindrome(head);

            System.out.println(f ? "true" : "false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


/* Structure of class Node is
class Node
{
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/

class Solution {
   
    
    // Function to Get the Middle Node of the Linked List
    static Node getMiddleNode(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return fast != null ? slow.next : slow; // This will give the Middle Node of the Linked Lists
    }
    // Function to check whether the list is palindrome.
    static boolean isPalindrome(Node head) {
        // Your code here
        if (head == null || head.next == null) return true;
        
        // Creating an Empty Stack
        Stack<Integer> stack = new Stack();
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }
        Node currMiddle = fast != null ? slow.next : slow;
        Node currStart = head;
        while (currMiddle != null) {
            if (stack.pop() != currMiddle.data) return false;
            currStart = currStart.next;
            currMiddle = currMiddle.next;
        }
        
        return true;
        
    }
}
