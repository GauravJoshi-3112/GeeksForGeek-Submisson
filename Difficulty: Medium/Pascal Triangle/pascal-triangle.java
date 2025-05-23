// User function Template for Java

class Solution {

    ArrayList<Integer> nthRowOfPascalTriangle(int n) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        result.add(1);
        
        for(int i=1; i<n; i++) {
            ArrayList<Integer> next = new ArrayList<>();
            for(int j=0; j<=result.size(); j++) {
                if (j == 0 || j == result.size()) next.add(1);
                else next.add(result.get(j) + result.get(j-1));
            }
            result = next;
        }
        
        return result;
        
    }
}