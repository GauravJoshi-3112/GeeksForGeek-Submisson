/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Solution {
    
    ArrayList<Integer> result;
    
    // Helper Function
    void leftViewHelp(Node root, int index) {
        if (root == null) return;
        else {
            while (result.size() <= index) result.add(-1); // will not be executed every time
            if (result.get(index) == -1) result.set(index, root.data);
            leftViewHelp(root.left, index+1);
            leftViewHelp(root.right, index+1);
        }
    }
    // Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root) {
        // code here
        result = new ArrayList<>();
        leftViewHelp(root,0);
        return result;
    }
}