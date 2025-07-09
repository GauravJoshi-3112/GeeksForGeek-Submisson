/*
class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Solution {
    int index = 1;
    // return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(Node root, int k) {
        // Your code here
        // We will apply post order traveral
        if (root == null) return -1;
        
        // make the Right Order Traversal
        int right = kthLargest(root.right, k);
        if (right != -1) return right;
        
        if (index == k) return root.data;
        else index++;
        
        return kthLargest(root.left, k);
    }
}