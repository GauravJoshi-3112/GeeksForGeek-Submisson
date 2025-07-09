/*
   Node class is Defined as follows:
   class Node{
       int data;
       Node left;
       Node right;
       Node nextRight;
       Node(int data){
           this.data = data;
           left=null;
           right=null;
           nextRight = null;
       }
   }
   */

class Solution {
    // Function to connect nodes at same level.
    public Node connect(Node root) {
        // Your code goes here.
        if (root == null) return root;
        // Doing a Level Order Traversal
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        // Traverse all Levels of Queue
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                Node elem = queue.poll();
                if (i != size - 1) elem.nextRight = queue.peek();
                if (elem.left != null) queue.offer(elem.left);
                if (elem.right != null) queue.offer(elem.right);
            }
        }
        
        return root;
        
    }
}