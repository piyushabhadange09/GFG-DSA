//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubstr(s));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        HashSet <Character> h=new HashSet<>();
        int i=0;
        int j=0;
        int max=0;
        while(j<s.length()){
            if(!h.contains(s.charAt(j))){
                h.add(s.charAt(j));
                j++;
                max=Math.max(max,h.size());
            }else{
                h.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }
}