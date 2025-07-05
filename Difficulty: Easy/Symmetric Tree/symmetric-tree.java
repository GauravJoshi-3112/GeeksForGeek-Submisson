/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

*/
class Solution {
    public boolean isSymmetric(Node root1, Node root2) {
        if (root1 == null && root2 == null) return true;
        else if (root1 == null || root2 == null) return false;
        else if (root1.data == root2.data) return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
        return false;
    }
    public boolean isSymmetric(Node root) {
        // Code here
        return isSymmetric(root.left, root.right);
    }
}