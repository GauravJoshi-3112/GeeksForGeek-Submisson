//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int m = Integer.parseInt(br.readLine().trim());
            int[][] image = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S2 = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) image[i][j] = Integer.parseInt(S2[j]);
            }
            int sr = Integer.parseInt(br.readLine().trim());
            int sc = Integer.parseInt(br.readLine().trim());
            int newColor = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for (int i = 0; i < ans.length; i++) {
                for (int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Code here
        // Using BFS Approach to solve the problem
        Queue<int []> q = new LinkedList<>();
        q.add(new int [] {sr,sc});
        int color = image[sr][sc];
        while (!q.isEmpty()) {
            int [] node = q.poll();
            if (node[0] < 0 || node[1] < 0 ||
                node[0] >= image.length || node[1] >= image[0].length ||
                image[node[0]][node[1]] == newColor ||
                image[node[0]][node[1]] != color) continue;
            else {
                image[node[0]][node[1]] = newColor;
                q.add(new int [] {node[0]+1,node[1]});
                q.add(new int [] {node[0],node[1]+1});
                q.add(new int [] {node[0]-1,node[1]});
                q.add(new int [] {node[0],node[1]-1});
            }
        }
        
        return image;
    }
}