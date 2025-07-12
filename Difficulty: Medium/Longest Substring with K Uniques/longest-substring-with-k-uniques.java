class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
          Map<Character, Integer> mp = new HashMap<>();
        int i = 0, j = 0;
        int n = s.length();
        int max = -1;
        while(j < n){
            // calculation
            char ch = s.charAt(j);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
            
            if(mp.size() < k){
                j++;
            }
            
            if(mp.size() == k){
                max = Math.max(max, j - i + 1);
                j++;
            }
            
            if(mp.size() > k){
                while(mp.size() > k){
                    mp.put(s.charAt(i), mp.get(s.charAt(i)) - 1);
                    if(mp.get(s.charAt(i)) == 0){
                        mp.remove(s.charAt(i));
                    }
                    i++;
                }
                j++;
            }
        }
        return max;
    }
}