/* Following is the Linked list node structure */

/*class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}*/

class Solution {
    
    Node getMiddle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    Node reverse(Node head) {
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    Node attach(Node head1, Node head2) {
        Node curr1 = head1;
        Node curr2 = head2;
        
        Node head = new Node(-1);
        Node curr = head;
        
        while (curr1 != null && curr2 != null) {
            Node next1 = curr1.next;
            Node next2 = curr2.next;
            
            curr.next = curr1;
            curr = curr.next;
            curr.next = curr2;
            curr = curr.next;
            
            curr1 = next1;
            curr2 = next2;
        }
        
        if (curr1 != null) {
            curr.next = curr1;
        }
        
        if (curr2 != null) {
            curr.next = curr2;
        }
        
        return head.next;
    }
    
    void reorderlist(Node head) {
        // Your code here
        // We need to follow Three Step
        // Find Middle
        Node mid = getMiddle(head);
        
        // Reverse from Middle to End
        Node midNext = mid.next;
        mid.next = null;
        
        Node head2 = reverse(midNext);
        // Attach Nodes
        head = attach(head, head2);

    }
}