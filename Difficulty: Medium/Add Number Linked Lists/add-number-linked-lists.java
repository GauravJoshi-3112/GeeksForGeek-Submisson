/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution {
    static Node reverseList(Node head) {
        while (head != null && head.data == 0) head = head.next;
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
    
    static Node reverseList(Node head, Boolean flag) {
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
    
    static Node addTwoNumber(Node num1, Node num2) {
        Node curr1 = num1;
        Node curr2 = num2;
        int carry = 0;
        Node temp = new Node(-1);
        Node curr = temp;
        while (curr1 != null && curr2 != null) {
            int num = curr1.data + curr2.data + carry;
            carry = (num/10) >= 1 ? 1 : 0;
            
            Node next = new Node(num%10);
            curr.next = next;
            curr = curr.next;
            
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        
        while (curr1 != null) {
            int num = curr1.data + carry;
            carry = (num/10) >= 1 ? 1 : 0;
            
            Node next = new Node(num%10);
            curr.next = next;
            curr = curr.next;
            
            curr1 = curr1.next;
        }
        
        while (curr2 != null) {
            int num = curr2.data + carry;
            carry = (num/10) >= 1 ? 1 : 0;
            
            Node next = new Node(num%10);
            curr.next = next;
            curr = curr.next;
            
            curr2 = curr2.next;
        }
        
        if (carry != 0) {
            int num = carry;
            
            Node next = new Node(num%10);
            curr.next = next;
            curr = curr.next;
        }
        
        return temp.next;
    }
    
    static Node addTwoLists(Node num1, Node num2) {
        // code here
        num1 = reverseList(num1);
        num2 = reverseList(num2);
        
        Node head = addTwoNumber(num1, num2);
        
        return reverseList(head,true);
        
    }
}