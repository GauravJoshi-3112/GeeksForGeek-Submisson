//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input1 = sc.nextLine();
            Scanner ss1 = new Scanner(input1);
            while (ss1.hasNextInt()) {
                arr.add(ss1.nextInt());
            }
            Solution ob = new Solution();
            int res = ob.findKRotation(arr);
            System.out.println(res);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findKRotation(List<Integer> arr) {
        // Index of Minimum Element is the Number of Rotation 
        // No of Rotation = 0 if minIndex = 0;
        int start = 0;
        int end = arr.size()-1;
        int mid = (start+end)/2;
        int min = arr.get(0), minIndex = 0;
        while (start <= end) {
            mid = (start + end)/2;
            if (arr.get(start) <= arr.get(mid)) {
                if (arr.get(start) < min) {
                    min = arr.get(start);
                    minIndex = start;
                }
                start = mid + 1;
            } else {
                if (arr.get(mid) < min) {
                    min = arr.get(mid);
                    minIndex = mid;
                }
                end = mid-1;
            }
        }
        return minIndex;
        
    }
}