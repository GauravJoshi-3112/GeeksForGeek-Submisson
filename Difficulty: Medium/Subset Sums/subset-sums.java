// User function Template for Java//User function Template for Java
class Solution {
    
    ArrayList<Integer> list;
    public void subsetSums(int [] arr, int index) {
        if (index >= arr.length) {
            list.add(0); 
        } else {
            subsetSums(arr, index+1);
            int N = list.size();
            for(int i=0; i<N; i++) {
                list.add(list.get(i)+arr[index]);
            }
        }
    }
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        list = new ArrayList<>();
        subsetSums(arr, 0);
        return list;
    }
}