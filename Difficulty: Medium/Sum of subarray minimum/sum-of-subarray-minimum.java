class Solution {
    public int sumSubMins(int[] arr) {
        // code here
        int arrSum=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            int minv=Integer.MAX_VALUE;
            for(int j=i;j<n;j++){
                minv=Math.min(minv,arr[j]);
                arrSum += minv;
            }
        }
        return arrSum;
    }
}
