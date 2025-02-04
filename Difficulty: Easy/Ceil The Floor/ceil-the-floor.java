//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int x = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            Solution ob = new Solution();
            int[] ans = ob.getFloorAndCeil(x, arr);
            System.out.println(ans[0] + " " + ans[1]);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    public int getFloor(int x, int[] arr) {
        int floor = arr.length;
        // Defining the Search Space
        int start = 0, end = arr.length -1;
        
        while (start <= end) {
            int mid = (start+end)/2;
            if (arr[mid] > x) {
                end = mid-1;
            } else {
                floor = mid;
                start = mid+1;
            }
        }
        return floor;
    }
    
    public int getCeil(int x, int[] arr) {
        int ceil = arr.length;
        // Defining the Search Space
        int start = 0, end = arr.length -1;
        
        while (start <= end) {
            int mid = (start+end)/2;
            if (arr[mid] >= x) {
                end = mid-1;
                ceil = mid;
            } else {
                start = mid+1;
            }
        }
        return ceil;
    }
    public int[] getFloorAndCeil(int x, int[] arr) {
        // Finding the floor and ceiling of an array (Lower Bound & Upper Bound)
        // Sorting the Unsorted Array
        Arrays.sort(arr);
        int floorIndex = getFloor(x, arr);
        int floorElem = floorIndex == -1 || floorIndex == arr.length ? -1 : arr[floorIndex];
        int ceilIndex = getCeil(x, arr);
        int ceilElem = ceilIndex == -1 || ceilIndex == arr.length ? -1 : arr[ceilIndex];
        return new int [] {floorElem, ceilElem};
    }
}
