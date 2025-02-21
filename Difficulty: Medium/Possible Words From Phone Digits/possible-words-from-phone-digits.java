//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(ArrayList<String> a) {
        for (String e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String arr[] = br.readLine().split(" ");
            int a[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                a[i] = Integer.parseInt(arr[i]);
            }

            Solution obj = new Solution();
            ArrayList<String> v = obj.possibleWords(a);
            Collections.sort(v); // Sorting the ArrayList lexicographically
            IntArray.print(v);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public String [] array = new String [] {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    
    public ArrayList<String> possibleWords(int index, int [] arr) {
        if (index == arr.length) return new ArrayList<String>(){{add("");}};
        ArrayList<String> words = possibleWords(index+1,arr);
        ArrayList<String> combination = new ArrayList<>();
        for (char ch : array[arr[index]].toCharArray()) {
            for(String str : words) {
                combination.add(Character.toString(ch)+str);
            }
        }
        return combination;
    }
    
    public ArrayList<String> possibleWords(int[] arr) {
        // Store Array Elements Corresponding to Index
        return possibleWords(0,arr);
    }
}