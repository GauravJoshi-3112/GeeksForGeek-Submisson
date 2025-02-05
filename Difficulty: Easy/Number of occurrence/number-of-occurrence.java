//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.countFreq(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    int getBoundIndex (int[] arr,int target,boolean boundFlag) {
        int start = 0, end = arr.length - 1;
        int index = boundFlag ? arr.length : -1;
        while(start <= end) {
            int mid = (start+end)/2;
            if (arr[mid] >= target && boundFlag) {
                index = mid;
                end = mid-1;
            } else if (arr[mid] <= target && !boundFlag) {
                index = mid;
                start = mid+1;
            } else if (arr[mid] < target) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return index;
    }
    int countFreq(int[] arr, int target) {
        int lowerBound = getBoundIndex (arr, target, true);
        if (lowerBound == arr.length) return 0;
        int upperBound = getBoundIndex (arr, target, false);
        return upperBound - lowerBound + 1;
    }
}
