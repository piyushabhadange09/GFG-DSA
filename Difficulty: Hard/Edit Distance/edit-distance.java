//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String s2 = br.readLine();

            Solution ob = new Solution();
            int ans = ob.editDistance(s1, s2);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
      int[][] dp;
    public int editDistance(String s1, String s2) {
         dp = new int[s1.length()][s2.length()];
        
        for(int [] arr : dp)
         Arrays.fill(arr , -1);
       return solve(0,0,s1,s2);
    }
    public int solve (int i , int  j , String s1, String s2){
        if(i == s1.length() && j == s2.length())
            return 0;
        if(i == s1.length())
         return s2.length() - j;
        if(j == s2.length())
            return s1.length() - i;
            
        if(dp[i][j] != -1)
            return dp[i][j];
            
        int min = 0 , first = 0 , second = 0 , third = 0;
            
        if(s1.charAt(i) == s2.charAt(j))
           return dp[i][j] = solve(i + 1 , j + 1 ,s1 , s2);
        else{
             first = solve(i + 1 , j + 1 ,s1 , s2); // Replace
             second = solve(i + 1 , j  , s1 ,  s2); // Remove
             third = solve(i , j + 1 ,s1 , s2); // Insert
        }
         
         dp[i][j]  = 1 + Math.min(first,Math.min(second,third));
         
         return dp[i][j];
    }
}