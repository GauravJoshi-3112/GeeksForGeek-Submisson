// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class Solution {
    int index = 1;
    // Return the Kth smallest element in the given BST
    public int kthSmallest(Node root, int k) {
        // Write your code here
        if (root == null) return -1; // The Edge Case Outside Index 
        
        int left = kthSmallest(root.left, k);
        if (left != -1) return left; // Index Exsits at Left Index
        
        // Root is the Index
        if (index == k) return root.data;
        
        // Increament Index for Right Traversal
        index++;
        return kthSmallest(root.right, k);
    }
}