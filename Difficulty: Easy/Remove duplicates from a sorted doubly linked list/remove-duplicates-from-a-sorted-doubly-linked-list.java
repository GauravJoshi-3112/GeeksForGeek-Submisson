//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static PrintWriter ot;
    public static void main(String args[]) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        
        int t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine().trim());
            Node head, tail;
            String s[] = br.readLine().trim().split(" ");
            int x = Integer.parseInt(s[0]);
            head = new Node(x);
            tail = head;
            for(int i = 1;  i < n; i++){
                x = Integer.parseInt(s[i]);
                Node temp = new Node(x);
                tail.next = temp;
                temp.prev = tail;
                tail = temp;
            }
            Solution soln = new Solution();
            head = soln.removeDuplicates(head);

            if(verify(head))
                displayList(head);
            else
                ot.println("Your pointers are not correctly connected");
            
        }
        ot.close();
    }
    static boolean verify(Node head){
        int fl = 0, bl = 0;
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
            fl++;
        }
        while(temp.prev != null){
            temp = temp.prev;
            bl++;
        }
        return fl == bl;
    }
    static void displayList(Node head){
        while(head.next != null){
            ot.print(head.data + " ");
            head = head.next;
        }
        ot.println(head.data);
    }
}
class Node{
    int data;
    Node next, prev;
    Node(int x){
        this.data = x;
        this.next = null;
        this.prev = null;
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    Node removeDuplicates(Node head){
        if (head == null || head.next == null) return head;
        Node temp1 = head;
        Node temp2 = head.next;
        while (temp2 != null) {
            if (temp2.data != temp1.data) {
                temp2.prev = temp1;
                temp1.next = temp2;
                temp1 = temp2;
            }
            temp2 = temp2.next;
        }
        temp1.next = temp2;
        return head;
    }
}