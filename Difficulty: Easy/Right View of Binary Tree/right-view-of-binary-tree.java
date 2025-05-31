/*Complete The Function Provided
Given Below is The Node Of Tree
class Node
{
    int data;
    Node left, right;
    public Node(int data)
    {
        this.data = data;
         left = right = null;
    }
}*/

class Solution {
    
    ArrayList<Integer> result;
    
    void rightView(Node root, int index) {
        if (root == null) return;
        
        if (result.size() == index) result.add(root.data);
        
        rightView(root.right,index+1);
        rightView(root.left,index+1);
    }
    
    // Function to return list containing elements of right view of binary tree.
    ArrayList<Integer> rightView(Node root) {
        // add code here.
        result = new ArrayList<>();
        rightView(root,0);
        return result;
    }
}