//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    
    // Function to Reverse a Linked List
    public Node reverseLinkedList(Node head) {
        Node curr = head;
        Node prev = curr;
        while (curr != null) {
            Node next = curr.next;
            if (curr != prev) curr.next = prev;
            else curr.next = null;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    public Node addOne(Node head) {
        // Reverse Linked List
        Node rHead = reverseLinkedList(head);
        Node curr = rHead;
        int carry = 1;
        while (curr != null) {
            int sum = curr.data + carry;
            if (sum >= 10) {
                sum = sum - 10;
                carry = 1;
            } else carry = 0;
            curr.data = sum;
            curr = curr.next;
        }
        
        if (carry != 0) {
            Node node = new Node(carry);
            head.next = node;
            head = head.next;
        }
        
        return reverseLinkedList(rHead);
    }
}
