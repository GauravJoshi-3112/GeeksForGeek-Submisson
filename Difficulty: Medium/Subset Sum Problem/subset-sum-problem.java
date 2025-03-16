//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int N = input_line.length;
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isSubsetSum(arr, sum))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    static Boolean isSubsetSumHelp(int arr[], int sum, int n) {
        if (sum == 0) return true;
        if (n < 0) return false;
        // Not a valid case
        if (arr[n] > sum) return isSubsetSumHelp(arr, sum, n-1);
        else {
            // Case 1 :- Considering the Element
            if (isSubsetSumHelp(arr, sum-arr[n], n-1)) return true;
            // Case 2 :- By Not Considering the Current Element
            if (isSubsetSumHelp(arr, sum, n-1)) return true;
            return false;
        }
    }
    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        return isSubsetSumHelp(arr,sum, arr.length-1);
    }
}