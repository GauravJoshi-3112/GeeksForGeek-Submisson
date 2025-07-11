class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        HashMap<Integer,Integer> prefxor = new HashMap<>();
        prefxor.put(0, 1);
        
        int xor = 0;
        int count = 0;
        
        for(int elem : arr) {
            xor = xor ^ elem;
            if (prefxor.containsKey(xor^k)) {
                count += prefxor.get(xor^k);
            }
            prefxor.put(xor, prefxor.getOrDefault(xor, 0) + 1);
        }
        return count;
    }
}