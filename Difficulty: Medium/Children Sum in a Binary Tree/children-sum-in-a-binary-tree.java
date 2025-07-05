/*Complete the function below
Node is as follows:
class Node{
    int data;
    Node left,right;

    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

*/
class Solution {
    // Function to check whether all nodes of a tree have the value
    // equal to the sum of their child nodes.
    public static int isSumProperty(Node root) {
        // add your code here
        if (root == null) return 1;
        else if (root.left == null && root.right == null) return 1;
        
        int left = 0;
        if (root.left != null) left = root.left.data;
        
        int right = 0;
        if (root.right != null) right = root.right.data;
        
        if (left + right == root.data) return isSumProperty(root.left)*isSumProperty(root.right);
        else return 0;
        
    }
}