class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(int[] arr) {
        // code here
        int i = 0, j = 0, k = arr.length - 1;
        while (j <= k) {
            if (arr[j] == 2) {
                arr[j] = arr[k];
                arr[k--] = 2;
            } else if (arr[j] == 0) {
                int temp = arr[i];
                arr[i] = 0;
                arr[j] = temp;
                i++;
                j++;
            } else {
                j++;
            }
        }
    }
}