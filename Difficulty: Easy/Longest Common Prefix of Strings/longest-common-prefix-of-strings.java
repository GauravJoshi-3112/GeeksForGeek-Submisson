// User function Template for Java
class Solution {
    public String longestCommonPrefix(String arr[]) {
        // code here
        Arrays.sort(arr);
        String i = arr[0];
        String j = arr[arr.length-1];
        int curr = 0;
        while (curr < i.length() && curr < j.length()) {
            if (i.charAt(curr) != j.charAt(curr)) break;
            curr++;
        }
        
        return i.substring(0,curr);
    }
}