/*class Node
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

// arr is an array of Nodes of the heads of linked lists

class Solution {
    Node mergeTwoList(Node head1, Node head2) {
        Node head = new Node(-1);
        Node curr = head;
        
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }
        
        if (head1 != null) curr.next = head1;
        if (head2 != null) curr.next = head2;
        
        return head.next;
        
    }
    
    Node mergeKLists(List<Node> arr, int start, int end) {
        if (start == end) return arr.get(start);
        int mid = start + (end - start)/2;
        Node node1 = mergeKLists(arr, start, mid);
        Node node2 = mergeKLists(arr, mid+1, end);
        return mergeTwoList(node1, node2);
    }
    // Function to merge K sorted linked list.
    Node mergeKLists(List<Node> arr) {
        // Add your code here.
        return mergeKLists(arr, 0, arr.size()-1);
    }
}