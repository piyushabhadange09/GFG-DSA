class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        // code here
        int n=arr.length;
        HashSet <Integer> hset=new HashSet<>();
        for(int i=0;i<n;i++){
            int sqr=arr[i]*arr[i];
            hset.add(sqr);
        }
        
        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                int k=arr[i]*arr[i]+arr[j]*arr[j];
                if(hset.contains(k)) return true;
            }
        }
        
        return false;
    }
}