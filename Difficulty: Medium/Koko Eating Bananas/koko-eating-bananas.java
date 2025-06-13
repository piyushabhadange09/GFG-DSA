class Solution {
    public int kokoEat(int[] arr, int k) {
        // code here
        int max = Arrays.stream(arr).max().getAsInt();
        int low  = 1 , high = max;
        int ans = 0;
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(mid,arr,k)){
                high = mid - 1;
                ans = mid;
            }
            else
            low = mid+1;
        }
        return ans;
    }
     public boolean isPossible(int s , int[] arr, int k){
        int hours = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] < s)
                hours++;
            else{
                if(arr[i] % s == 0)
                    hours += arr[i] / s;
                else
                hours += (arr[i] / s) + 1;
            }
        }
        
        return hours <= k;
    }
}
