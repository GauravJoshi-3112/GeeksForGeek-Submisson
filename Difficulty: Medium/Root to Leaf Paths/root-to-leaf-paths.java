/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    
    
    public static void PathsHelp(Node root, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result) {
        if (root == null) return;
        
        path.add(root.data);
        if (root.left == null && root.right == null) {
            ArrayList<Integer> list = new ArrayList<>(path);
            result.add(list);
        } else {
            PathsHelp(root.left,path,result);
            PathsHelp(root.right,path,result);
        }
        path.remove(path.size()-1);
    }
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        PathsHelp(root, new ArrayList<>(),result);
        return result;
    }
}