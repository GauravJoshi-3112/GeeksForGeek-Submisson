//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            String[] str =
                (br.readLine()).trim().split(" "); // Reading input as a string array
            int arr[] = new int[str.length];       // Creating integer array from input
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            // Getting the result from the Solution class
            ArrayList<Integer> result =
                new Solution().findSubarray(arr); // Change List to ArrayList

            // Printing the result in the required format
            if (result.isEmpty()) {
                System.out.println("[]");
            } else {
                for (int i = 0; i < result.size(); i++) {
                    if (i != 0) System.out.print(" ");
                    System.out.print(result.get(i));
                }
                System.out.println();
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public ArrayList<Integer> findSubarray(int arr[]) {
        // code here
        int bStart = -1, bEnd = -1, bSum = 0;
        int cStart = 0, cEnd = 0, cSum = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<arr.length; i++) {
            if (arr[i] < 0) {
                cStart = i+1;
                cEnd = i+1;
                cSum = 0;
            } else {
                cEnd = i;
                cSum += arr[i];
            }
             // Negative
            if (cSum > bSum || (cStart == bStart && cSum == bSum)) {
                bStart = cStart;
                bEnd = cEnd;
                bSum = cSum;
            }
        }
        
        if ((bStart == -1) && (bEnd == -1)) list.add(-1);
        
        for(int i=bStart; i<= bEnd && i>= 0 && i<arr.length ; i++) {
            list.add(arr[i]);
        }
        
        return list;
        
    }
}