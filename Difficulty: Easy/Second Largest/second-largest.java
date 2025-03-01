//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.getSecondLargest(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int getSecondLargest(int[] arr) {
        // If Length of Array == 0 && 1 Return -1 (No Second largest Element Exists)
        if (arr.length <= 1) return -1;
        
        int largest = -1;
        int sLargest = -1;
        for (int elem : arr) {
            if (elem > largest) {
                if (sLargest < largest) sLargest = largest;
                largest = elem;
            } else if (elem > sLargest && elem != largest) {
                sLargest = elem;
            }
        }
        return sLargest;
    }
}