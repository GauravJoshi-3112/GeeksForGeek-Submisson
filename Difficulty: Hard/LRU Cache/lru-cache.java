//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class LRUDesign {

    private static List<String> inputLine(Scanner sc) {
        return Arrays.asList(sc.nextLine().split(" "));
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int capacity = Integer.parseInt(sc.nextLine());
            LRUCache cache = new LRUCache(capacity);

            int queries = Integer.parseInt(sc.nextLine());
            while (queries-- > 0) {
                List<String> vec = inputLine(sc);
                if (vec.get(0).equals("PUT")) {
                    int key = Integer.parseInt(vec.get(1));
                    int value = Integer.parseInt(vec.get(2));
                    cache.put(key, value);
                } else {
                    int key = Integer.parseInt(vec.get(1));
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends

class Node {
    int key;
    int value;
    Node next;
    Node prev;
    
    Node (int key, int value, Node next, Node prev) {
        this.key = key;
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
    
    Node (int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    HashMap<Integer,Node> map;
    Node head;
    Node tail;
    int capacity;
    

    LRUCache(int cap) {
        // code here
        this.map = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.capacity = cap;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node keyNode = map.get(key);
        Node prevNode = keyNode.prev;
        Node nextNode = keyNode.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        
        tail.prev.next = keyNode;
        keyNode.prev = tail.prev;
        tail.prev = keyNode;
        keyNode.next = tail;
        return map.get(key).value;
    }

        
    public void put(int key, int value) {
        // your code here
        if (map.containsKey(key)) {
            Node node = map.get(key);
            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            node = null;
        } else if (map.size() == capacity) {
                // Delete head.next;
                // Remove Entry from Map
                Node headNext = head.next;
                headNext.next.prev = head;
                head.next = headNext.next;
                map.remove(headNext.key);
        }
        
        Node keyNode = new Node(key, value, tail, tail.prev);
        tail.prev.next = keyNode;
        tail.prev = keyNode;
        map.put(key, keyNode);
        
    }
}
