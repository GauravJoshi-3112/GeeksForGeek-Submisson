class Solution {
    
    public String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
    
    public String reverseWords(String s) {
        // Code here
        StringBuilder result = new StringBuilder();
        // Trim the Additional White Space
        s = s.trim();
        
        int i =0, j = 0;
        while (i < s.length() && j < s.length()) {
            
            // Remove Leading White Spaces
            while (i < s.length() && s.charAt(i) == ' ') {
                i++;
                j++;
            }
            
            while (j < s.length() && s.charAt(j) != ' ') {
                j++;
            }
            
            String reversed = reverse(s.substring(i,j));
            i = j;
            
            result.append(result.length() == 0 ? reversed : " " + reversed);
        }
        
        return result.toString();
    }
}
