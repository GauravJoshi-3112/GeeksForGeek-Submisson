// User function Template for Java

class Solution {
    
    static Node prev = null;
    public static void flattenBinaryTree(Node root) {
        if (root == null) return; // Base Case
        
        // Assume flattenBinaryTree will flatten your already existing Tree 
        flattenBinaryTree(root.right);
        flattenBinaryTree(root.left);
        root.right = prev;
        root.left = null;
        
        prev = root;
        
    }
    public static void flatten(Node root) {
        // code here
        // Flattening the Binary Tree to Linked List 
        // We will use the concept of Previous 
        flattenBinaryTree(root);
        prev = null;
    }
}