//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            int[] nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            ArrayList<Double> ans = ob.getMedian(nums);
            for (double i : ans) {
                System.out.printf("%.1f ", i);
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<Double> getMedian(int[] arr) {
        // Max Heap for the left half (lower values)
        PriorityQueue<Integer> pq_left = new PriorityQueue<>(Collections.reverseOrder());
        // Min Heap for the right half (higher values)
        PriorityQueue<Integer> pq_right = new PriorityQueue<>();

        ArrayList<Double> result = new ArrayList<>();

        for (int elem : arr) {
            // Insert into appropriate heap
            if (pq_left.isEmpty() || elem <= pq_left.peek()) {
                pq_left.add(elem);
            } else {
                pq_right.add(elem);
            }

            // Balance the heaps
            if (pq_left.size() > pq_right.size() + 1) {
                pq_right.add(pq_left.poll());
            } else if (pq_right.size() > pq_left.size()) {
                pq_left.add(pq_right.poll());
            }

            // Find the median
            if (pq_left.size() > pq_right.size()) {
                result.add((double) pq_left.peek());
            } else {
                result.add((pq_left.peek() + pq_right.peek()) / 2.0);
            }
        }

        return result;
    }
}
