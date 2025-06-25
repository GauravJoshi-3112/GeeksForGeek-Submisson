/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution {
    public static Node reverse(Node head, int count) {
        Node prev = null;
        Node curr = head;
        
        while (curr != null && count > 0) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count--;
        }
        
        head.next = curr;
        return prev;
    }
    public static Node reverseKGroup(Node head, int k) {
        // code here
        
        if (k <= 1) return head;
        
        Node tempHead = new Node(-1);
        tempHead.next = head;
        Node prev = tempHead;
        Node curr = head;
        int count = 0;
        
        while (curr != null) {
            curr = reverse(curr,k);
            prev.next = curr;
            count = k;
            
            while (curr != null && count > 0) {
                prev = curr;
                curr = curr.next;
                count--;
            }
        }
        
        return tempHead.next;
    }
}