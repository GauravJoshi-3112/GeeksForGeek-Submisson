/* Structure of node
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
} */

class Solution {

    // Function to find the data of kth node from
    // the end of a linked list.
    int getKthFromLast(Node head, int k) {
        // Your code here
        int count = k;
        Node fast = head;
        while (fast != null && count > 0) {
            fast = fast.next;
            count--;
        }
        
        if (count > 0) return -1;
        
        Node curr = head;
        while (fast != null) {
            curr = curr.next;
            fast = fast.next;
        }
        
        return curr.data;
        
    }
}