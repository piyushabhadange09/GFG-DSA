class Solution {
  public:
    int countAtMostK(vector<int> &s, int k) {
        // code here
          int i=0;
        int j=0;
        unordered_map<int,int>mp;
        int n=s.size();
        int ans=0;
        while(j<n){
            mp[s[j]]++;
            while(mp.size()>k){
                mp[s[i]]--;
                if(mp[s[i]]==0)mp.erase(s[i]);
                i++;
            }
            ans+=(j-i+1);
            j++;
        }
        return ans;
    }
};