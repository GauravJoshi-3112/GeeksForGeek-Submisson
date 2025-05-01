//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            int res = obj.nthTribonacci(n);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int nthTribonacci(int n) {
        // code here
        if (n == 0 || n == 1) return n;
        else if (n == 2) return n-1;
        
        int TN_3 = 0, TN_2 = 1, TN_1 = 1;
        int TN = TN_1 + TN_2 + TN_3;
        
        for(int i = 4; i<=n; i++) {
            TN_3 = TN_2;
            TN_2 = TN_1;
            TN_1 = TN;
            TN = TN_1 + TN_2 + TN_3;
        }
        
        return TN;
        
    }
}
