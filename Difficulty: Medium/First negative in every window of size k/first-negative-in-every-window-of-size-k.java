//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends

class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        // Its a Proper case for Sliding Window Algorithm 
        // How identfied
        /*
        1. There is a need of window of subaaray
        2. window size is given
        */
        
        int j = 0;
        // Creating Answer List
        List<Integer> firstNegList = new ArrayList<>();
        for(int i=0; i<= arr.length-k; i++) {
            while (j<arr.length && (j < i || arr[j] >= 0)) {
                j++;
            }
            // Conditon to check if j lies in window or not
            firstNegList.add( (j<= i+k-1) ? arr[j] : 0);
        }
        
        return firstNegList;
        
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
            List<Integer> ans = ob.firstNegInt(arr, k);

            // Print the result as a space-separated string
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println(); // New line after printing the results
            System.out.println("~");
        }
    }
}

// } Driver Code Ends