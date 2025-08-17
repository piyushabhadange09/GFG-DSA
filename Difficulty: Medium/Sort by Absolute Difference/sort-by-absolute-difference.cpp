class Solution {
  public:
    void rearrange(vector<int> &arr, int x) {
        // code here
        stable_sort(arr.begin() ,arr.end() ,[x](int n1 ,int n2){
            return abs(n1-x) < abs(n2-x);
        });
    }
};