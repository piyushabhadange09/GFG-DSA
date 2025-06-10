class Solution {
  public:
    int countStrings(string &s) {
        // code here
        vector<int> fr(26,0);
        int ans = 0;
       
        for(auto x:s) {if(fr[x-'a']++) ans= 1;}
        
        int n = s.size();
        int total = n;
        
        
        for(int i = 0;i<n-1;i++)
            ans+= (total---fr[s[i]-'a']--);
         
        return ans;
    }
};
