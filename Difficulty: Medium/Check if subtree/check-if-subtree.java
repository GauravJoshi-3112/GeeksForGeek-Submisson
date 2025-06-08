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
    public static boolean isValidSub(Node T, Node S) {
        if (T == null && S == null) return true;
        else if (T == null || S == null) return false;
        else if (T.data == S.data) return isValidSub(T.left,S.left) && isValidSub(T.right,S.right);
        else return false;
    }
    public static boolean isSubtree(Node T, Node S) {
        // add code here.
        if (S == null) return true;
        if (T == null) return false;
        if (isValidSub(T, S)) return true;
        else return isSubtree(T.left, S) || isSubtree(T.right, S);
    }
}