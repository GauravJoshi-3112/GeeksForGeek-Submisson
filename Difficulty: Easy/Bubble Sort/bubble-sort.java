//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends

// User function Template for Java

class Solution {
    // Function to sort the array using bubble sort algorithm.
    public static void bubbleSort(int arr[]) {
        // Bubble Sort Algorith Swaps Adjacent Element to make them in correct position for n-1 iterations
        int n = arr.length;
        // N-1 Iteration (If N-1 Element's are at Correct Position then Nth will be in Correct pos)
        for(int i=0; i<n-1; i++) {
            // For Every ITeration Swap Adjacent 
            boolean isSwapped = false; // Optimization for Already Sorted Array
            for(int j=0; j<n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    // Need to Perform Swapping
                    isSwapped = true;
                    // Swapping 
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if (!isSwapped) break; // Since No Swapping happens in this Iteration Array is Sorted
        }
    }
}


//{ Driver Code Starts.

class Sorting {
    // method to print the Elements of the array
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            // calling bubbleSort() method
            new Solution().bubbleSort(arr);

            // calling printArray() method
            printArray(arr);

            t--;
        }
    }
}
// } Driver Code Ends