// User function Template for Java

class Solution {
    static int majorityElement(int arr[]) {
        // We will be implementing Moore Vooting Algo
        int elem = -1;
        int count = 0;
        
        for(int i=0; i<arr.length; i++) {
            if (elem == arr[i]) count++;
            else if (count == 0) {
                // Change Candidate
                elem = arr[i];
                count = 1;
            } else {
                count--;
            }
        }
        
        int tempCount = 0;
        for(int i=0; i<arr.length; i++) {
            if (elem == arr[i]) tempCount++;
        }

        return tempCount > arr.length/2 ? elem : -1;
        
    }
}