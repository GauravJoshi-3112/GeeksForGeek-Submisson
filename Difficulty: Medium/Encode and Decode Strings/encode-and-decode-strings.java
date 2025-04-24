//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String s[] = br.readLine().split(" ");

            Solution obj = new Solution();

            String encodedString = obj.encode(s);
            String decodedStrings[] = obj.decode(encodedString);

            for (String x : decodedStrings) {
                System.out.print(x + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {

    public String encode(String s[]) {
        // write your logic to encode the strings
        StringBuilder encodedString = new StringBuilder("");
        encodedString.append(s.length+"%");
        for(String elem : s) {
            encodedString.append(elem.length()+"%"+elem);
        }
        return encodedString.toString();
    }

    public String[] decode(String s) {
        // To Decode the String we will first use the Number % 
        int start = 0, end = 0;
        String [] decodedString;
        while (s.charAt(end) != '%') end++;
        decodedString = new String[Integer.valueOf(s.substring(start,end))];
        int index = 0;
        start = ++end;
        while (end < s.length()) {
            if (start != end && s.charAt(end) == '%') {
                int size = Integer.parseInt(s.substring(start,end));
                decodedString[index++] = s.substring(end+1,end+size+1);
                end = end+size+1;
                start = end;
            } else {
                end++;
            }
        }
        return decodedString;
    }
}