class Solution {
    public Node mergeTwoLists(Node l1, Node l2) {
        Node head = new Node(-1);
        Node curr = head;

        Node curr1 = l1, curr2 = l2;

        while (curr1 != null && curr2 != null) {
            
            Node node = null;
            if (curr1.data <= curr2.data) {
                node = curr1;
                curr1 = curr1.bottom;
            } else {
                node = curr2;
                curr2 = curr2.bottom;
            }

            curr.bottom = node;
            curr = curr.bottom;
        }   

        if (curr1 != null) curr.bottom = curr1;
        if (curr2 != null) curr.bottom = curr2;

        return head.bottom;
    }
    
    // Function to flatten a linked list
    Node flatten(Node root) {
        // code here
        Node head = new Node(-1);
        head.next = root;
        
        Node curr = root;
        Node next = root.next;
        
        while (next != null) {
            Node newNext = next.next;
            curr = mergeTwoLists(curr, next);
            next = newNext;
        }
        
        return head.next;
    }
}