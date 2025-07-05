// User function Template for Java

/*
class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    
    public Node Bst(int [] preorder, int start, int end) {
        if (end < start) return null;
        
        Node root = new Node(preorder[start]);
        int i = start;
        while (i <= end) {
            if (preorder[i] > root.data) break;
            i++;
        }
        
        root.left = Bst(preorder, start+1, i-1);
        root.right = Bst(preorder, i, end);
        
        return root;
    }
    // Function that constructs BST from its preorder traversal.
    public Node Bst(int pre[], int size) {
        // code here
        return Bst(pre, 0, size - 1);
    }
}