//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr[idx++] = i;

            new Solution().mergeSort(arr, 0, arr.length - 1);

            for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");

            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public void mergeSortedArray(int [] arr,int start1, int end1, int start2, int end2) {
        int [] sortedArr = new int [end2 - start1 + 1];
        int start = 0;
        int index1 = start1, index2 = start2;
        while (index1 <= end1 && index2 <= end2) {
            if (arr[index1] == arr[index2]) {
                sortedArr[start++] = arr[index1++];
                sortedArr[start++] = arr[index2++];
            } else if (arr[index1] < arr[index2]) {
                sortedArr[start++] = arr[index1++];
            } else {
                sortedArr[start++] = arr[index2++];
            }
        }
        
        while (index1 <= end1) {
            sortedArr[start++] = arr[index1++];
        }
        
        while (index2 <= end2) {
            sortedArr[start++] = arr[index2++];
        }
        
        for (int elem : sortedArr) {
            arr[start1++] = elem;
        }
    }
    
    void mergeSort(int arr[], int l, int r) {
        // Base Case
        if (r <= l) return;
        int mid = (l+r)/2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        mergeSortedArray(arr,l,mid,mid+1,r);
    }
}
