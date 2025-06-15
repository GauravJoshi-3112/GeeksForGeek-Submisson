/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}  */
class Solution {
    public static Node traverseTree(Node root, HashMap<Node,Node> map, int target) {
        if (root == null) return null;
        else {
            if (root.left != null) map.put(root.left, root);
            if (root.right != null) map.put(root.right, root);
            Node left = traverseTree(root.left, map, target);
            Node right = traverseTree(root.right, map, target);
            if (left != null) return left;
            if (right != null) return right;
            return root.data == target ? root : null;
        }
    }
    
    public static int minTime(Node root, int target) {
        Queue<Node> queue = new LinkedList<>();
        HashMap<Node,Node> map = new HashMap<>();
        map.put(root, new Node(-1));
        
        int seconds = 0;
        Node targetNode = traverseTree(root, map, target);
        queue.offer(targetNode);
        
        while (!queue.isEmpty()) {
            int level = queue.size();
            for(int i=0; i<level; i++) {
                Node node = queue.poll();
                if (map.containsKey(node)) {
                    if (map.containsKey(map.get(node))) queue.offer(map.get(node));
                    if (map.containsKey(node.left)) queue.offer(node.left);
                    if (map.containsKey(node.right)) queue.offer(node.right);
                    map.remove(node);
                } else {
                    continue;
                }
            }
            if (!queue.isEmpty()) seconds++;
        }
        
        return seconds;
        
    }
}