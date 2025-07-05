/* BST Node
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
} */

class Solution {
    Node prev = null, next = null;
    public void findKey(Node root, int key) {
        if (root == null) return;
        else if (root.data > key) {
            next = root;
            findKey(root.left, key);
        } else if (root.data < key) {
            prev = root;
            findKey(root.right, key);
        } else {
            // Find the prev and next
            if (root.left != null) {
                Node curr = root.left;
                while (curr.right != null) curr = curr.right;
                prev = curr;
            } 
            
            if (root.right != null) {
                Node curr = root.right;
                while (curr.left != null) curr = curr.left;
                next = curr;
            } 
        }
    }
    
    public ArrayList<Node> findPreSuc(Node root, int key) {
        // code here
        findKey(root, key);
        ArrayList<Node> list = new ArrayList<>();
        list.add(prev);
        list.add(next);
        return list;
    }
}