/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    static ArrayList<ArrayList<Integer>> left;
    static ArrayList<ArrayList<Integer>> right;
    
    static void verticalOrderHelp(Node root, int index) {
        if (root == null) return;
        
        if (index >= 0) {
            while (right.size() <= Math.abs(index)) right.add(new ArrayList<>());
            right.get(index).add(root.data);
        } else {
            while (left.size() < Math.abs(index)) left.add(new ArrayList<>());
            left.get(Math.abs(index)-1).add(root.data);
        }
        
        verticalOrderHelp(root.left,index-1);
        verticalOrderHelp(root.right,index+1);
        
    }
    static ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
        left =  new ArrayList<>();
        right = new ArrayList<>();
        // add your code here
        verticalOrderHelp(root, 0);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Collections.reverse(left);
        result.addAll(left);
        result.addAll(right);
        return result;
    }
}