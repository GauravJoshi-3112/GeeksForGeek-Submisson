class Solution {
    // Function to remove duplicates from the given array
    public int removeDuplicates(int[] arr) {
        // Code Here
        int i = 0;
        int j = 1;
        while (j < arr.length) {
            if (arr[j] != arr[i]) {
                arr[i+1] = arr[j];
                i++;
            }
            j++;
        }
        return i+1;
    }
}