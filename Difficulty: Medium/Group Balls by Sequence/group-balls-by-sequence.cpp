class Solution {
  public:
    bool validgroup(vector<int> &arr, int k) {
        // code here
        unordered_map<int,int>mp;
        for(int i = 0; i< arr.size();i++){
            mp[arr[i]]++;
        }
        int n = arr.size();
        if(n % k != 0)
        return 0;
        vector<int>uniq;
        for(auto num:mp){
            uniq.push_back(num.first);
        }
        sort(uniq.begin(),uniq.end());
        int i = 0;
        while(i < uniq.size()){
            int el = uniq[i];
            int j= 0;
            while(j< k){
                if(mp[el] == 0)
                return 0;
                mp[el]--;
                if(mp[el] == 0)
                i++;
                el++;
                j++;
            }
        }
        return 1;
    }
};