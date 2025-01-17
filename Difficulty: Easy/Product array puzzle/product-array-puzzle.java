//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob = new Solution();
            int[] ans = new int[n];
            ans = ob.productExceptSelf(arr);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            System.out.println("~");
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int[] productExceptSelf(int arr[]) {
        // code here
        int n=arr.length;
        int res[]=new int[n];
        int zeroIndex=-1;
        int zerocnt=0;
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                zeroIndex=i;
                zerocnt++;
            }
        }
        if(zerocnt>1){
            for(int i=0;i<n;i++){
                res[i]=0;
            }
        }
        int product=1;
        int zeroProduct=1;
        if(zeroIndex!=-1){
            for(int i=0;i<n;i++){
                if(i!=zeroIndex){
                    zeroProduct=zeroProduct*arr[i];
                }
            }
            for(int i=0;i<n;i++){
                if(i==zeroIndex){
                    res[i]=zeroProduct;
                }else{
                    res[i]=0;
                }
            }
        }else{
            for(int i=0;i<n;i++){
                product=arr[i]*product;
            }
            for(int i=0;i<n;i++){
                int ele=product/arr[i];
                res[i]=ele;
            }
        }
        return res;
    }
}
