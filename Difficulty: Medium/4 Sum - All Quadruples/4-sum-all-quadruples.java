// User function Template for Java

// arr[] : int input array of integers
// target : the quadruple sum required

class Solution {
    public List<List<Integer>> fourSum(int[] arr, int target) {
        // code here
        Arrays.sort(arr); // First Sort the array
        List<List<Integer>> result = new ArrayList<>();
        
        int i = 0;
        while (i < arr.length - 3) {
            if (i != 0 && arr[i] == arr[i-1]) {
                i++;
                continue;
            }
            
            int j = i+1;
            while(j < arr.length - 2) {
                if (j != i+1 && arr[j] == arr[j-1]) {
                    j++;
                    continue;
                }
                
                
                int k = j+1;
                int l = arr.length - 1;
                while (k < l) {
                    if (k != j+1 && arr[k] == arr[k-1]) {
                        k++;
                        continue;
                    }
                    
                    if (l != arr.length - 1 && arr[l] == arr[l+1]) {
                        l--;
                        continue;
                    }
                    
                    int elem = arr[i] + arr[j] + arr[k] + arr[l];
                    if (elem == target) {
                        result.add(List.of(arr[i], arr[j], arr[k], arr[l]));
                        k++;
                        l--;
                    } else if (elem > target) l--;
                    else k++;
                }
                j++;
                
            }
            i++;
        }
        
        return result;
    }
}