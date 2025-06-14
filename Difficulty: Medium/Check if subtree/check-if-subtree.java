/*complete the given function*/

/* class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=null;
        right=null;
    }
}*/

class Solution {
    public static boolean identical (Node T, Node S) {
        if (T == null && S == null) return true;
        else if (T == null || S == null) return false;
        else if (T.data != S.data) return false;
        boolean leftIdentical = identical(T.left, S.left);
        if (!leftIdentical) return false;
        boolean rightIdentical = identical(T.right, S.right);
        return rightIdentical;
    }
    public static boolean isSubtree(Node T, Node S) {
        // add code here.
        if (S == null) return true;
        if (T == null) return false;
        if (identical(T, S)) return true;
        else  return isSubtree(T.left, S) || isSubtree(T.right, S);
    }
}