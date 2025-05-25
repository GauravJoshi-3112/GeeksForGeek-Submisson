// User function Template for Java

class Solution {
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String s) {
        // code here
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',   1);
        map.put('V',   5);
        map.put('X',  10);
        map.put('L',  50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M',1000);
        
        int total = 0;
        int curr = 0;
        int j = s.length() - 1;
        int i = j;
        while (j >= 0) {
            curr = map.get(s.charAt(j));
            i--;
            while (i>= 0 && map.get(s.charAt(i)) < map.get(s.charAt(j))) {
                curr = curr - map.get(s.charAt(i));
                i--;
            }
            total += curr;
            j = i;
        }
        
        return total;
    }
}