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
    public static ArrayList<ArrayList<Integer>> result;
    public static void PathsHelp(Node root, List<Integer> path) {
        if (root == null) return;
        else if (root.left == null && root.right == null) {
            ArrayList<Integer> currPath = new ArrayList<>();
            currPath.addAll(path);
            currPath.add(root.data);
            result.add(currPath);
        } else {
            path.add(root.data);
            PathsHelp(root.left, path);
            PathsHelp(root.right, path);
            path.remove(path.size()-1);
        }
    }
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        result = new ArrayList<>();
        PathsHelp(root, new ArrayList<>());
        return result;
    }
}