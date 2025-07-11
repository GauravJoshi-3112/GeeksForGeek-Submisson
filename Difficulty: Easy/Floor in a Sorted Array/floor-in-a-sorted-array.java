//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends
class Solution {

    static int findFloor(int[] arr, int k) {
        // Defining the possible floor, start and end
        int start = 0, end = arr.length-1, floor = arr.length;
        
        // Iterative Binary Search
        while (start <= end) {
            
            //Retrieving Middle Element from the Array
            int mid = (start + end)/2;
            
            // If element at mid index >= k then update floor 
            // Because if found element >= k then floor range must be in left
            if (arr[mid] >= k) {
                floor = arr[mid] == k ? mid : mid-1;
                end = mid-1;
            }
            
            // If element at mid index < k then update floor 
            // Because if found element < k then floor range must be in right
            if(arr[mid] < k) start = mid+1;
        }
        
        return floor;
        
    }
}


//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int ans = ob.findFloor(arr, k);

            System.out.print(ans);

            System.out.println(); // New line after printing the results
        }
    }
}

// } Driver Code Ends