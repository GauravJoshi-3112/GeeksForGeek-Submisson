/*linked list node
class Node {
    int data;
    Node next;
    Node random;

    Node(int x) {
        data = x;
        next = null;
        random = null;
    }
}
*/
class Solution {
    public Node cloneLinkedList(Node head) {
        // code here
        Node tempHead = new Node(-1);
        Node curr = head;
        Node temp = tempHead;
        
        // Creating a HashMap
        HashMap<Node,Node> map = new HashMap<>();
        
        while (curr != null) {
            Node next = new Node(curr.data);
            temp.next = next;
            map.put(curr,next);
            temp = temp.next;
            curr = curr.next;
        }
        
        curr = head;
        temp = tempHead.next;
        while (curr != null) {
            temp.random = map.get(curr.random);
            curr = curr.next;
            temp = temp.next;
        }
        
        return tempHead.next;
        
        
        
        
    }
}