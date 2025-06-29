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


// } Driver Code Ends

// User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        // add your code here
        Node head_0 = new Node(-1);
        Node head_1 = new Node(-1);
        Node head_2 = new Node(-1);
        Node curr_0 = head_0, curr_1 = head_1, curr_2 = head_2;
        
        Node curr = head;
        
        // Traversing the Linked Lists
        while(curr != null) {
            if (curr.data == 0){
                curr_0.next = curr;
                curr_0 = curr_0.next;
            } else if (curr.data == 1) {
                curr_1.next = curr;
                curr_1 = curr_1.next;
            } else {
                curr_2.next = curr;
                curr_2 = curr_2.next;
            }
            curr = curr.next;
        }
        
        curr_2.next = null;
        curr_1.next = head_2.next;
        curr_0.next = head_1.next;
        return head_0.next;
    }
}



//{ Driver Code Starts.

class GFG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); i++) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            head = new Solution().segregate(head);
            printList(head);
        }
    }
}
// } Driver Code Ends