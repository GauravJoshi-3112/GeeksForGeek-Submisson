//{ Driver Code Starts
// Initial Template for JAVA

import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;


// } Driver Code Ends

// User function Template for Java

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
    
    // Function to return a list of nodes visible from the top view
    static ArrayList<Integer> topView(Node root) {
        if (root == null) return new ArrayList<>();  // Edge case

        class NodeGrid {
            Node node;
            int gridIndex;

            NodeGrid(Node node, int grid) {
                this.node = node;
                this.gridIndex = grid;
            }
        }

        // Level Order Traversal using Queue
        Queue<NodeGrid> nodeGridQueue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();  // TreeMap to store nodes in sorted order
        ArrayList<Integer> arr = new ArrayList<>();

        nodeGridQueue.offer(new NodeGrid(root, 0));

        while (!nodeGridQueue.isEmpty()) {  // ✅ Corrected condition
            NodeGrid temp = nodeGridQueue.poll();

            // ✅ Insert only if the grid index is not already present
            if (!map.containsKey(temp.gridIndex)) {
                map.put(temp.gridIndex, temp.node.data);
            }

            // ✅ Add left and right children to the queue
            if (temp.node.left != null) {
                nodeGridQueue.offer(new NodeGrid(temp.node.left, temp.gridIndex - 1));
            }
            if (temp.node.right != null) {
                nodeGridQueue.offer(new NodeGrid(temp.node.right, temp.gridIndex + 1));
            }
        }

        arr.addAll(map.values());
        return arr;
    }
}


//{ Driver Code Starts.

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Tree {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution ob = new Solution();

            ArrayList<Integer> vec = ob.topView(root);
            for (int x : vec) System.out.print(x + " ");
            System.out.println();

            t--;

            System.out.println("~");
        }
    }
}
// } Driver Code Ends