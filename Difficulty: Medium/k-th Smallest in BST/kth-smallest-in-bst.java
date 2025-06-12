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
        if (root == null) return -1;
        int left = kthSmallest(root.left, k);
        if (left != -1) return left;
        if (index == k) return root.data;
        else index+=1;
        return kthSmallest(root.right, k);
    }
}