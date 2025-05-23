// User function Template for Java

class Solution {
    // Function to find the days of buying and selling stock for max profit.
    int stockBuySell(int arr[]) {
        // Subtract with Next
        int profit = 0;
        for(int i=0; i<arr.length-1; i++) {
            arr[i] = arr[i+1] - arr[i];
            if (arr[i] >= 0) profit += arr[i];
        }
        return profit;
    }
}
