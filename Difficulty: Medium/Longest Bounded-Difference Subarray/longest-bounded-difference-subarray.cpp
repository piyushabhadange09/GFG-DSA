//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    vector<int> longestSubarray(vector<int>& arr, int x) {
        // code here
           deque<int>maxi;
        deque<int>mini;
        int n = arr.size();
        int i = 0 , j = 0;
        vector<int>ans;
        int st = -10 , en = -100;
        while(j < n){
            while(!maxi.empty() and arr[j] >= arr[maxi.front()]){
                maxi.pop_front();
            }
            while(!mini.empty() and arr[j] <= arr[mini.front()]){
                mini.pop_front();
            }
            maxi.push_front(j);
            mini.push_front(j);
            int diff = arr[maxi.back()] - arr[mini.back()];
            if(diff <= x){
                if(j-i+1 > en-st+1){
                    st = i , en = j;
                }
                j++;
            }
            else{
                while(i <= j and diff > x){
                    if(mini.back() == i){
                        mini.pop_back();
                    }
                    if(maxi.back() == i){
                        maxi.pop_back();
                    }
                    if(!maxi.empty() and !mini.empty()){
                        diff = arr[maxi.back()] - arr[mini.back()];
                    }
                    i++;
                }
                if(i <= j and j-i+1 > en-st+1){
                    st = i , en = j;
                }
                j++;
            }
        }
        for(int i=st;i<=en;i++){
            ans.push_back(arr[i]);
        }
        return ans;
    }
};


//{ Driver Code Starts.
int main() {
    string ts;
    getline(cin, ts);
    int t = stoi(ts);
    while (t--) {

        vector<int> arr;
        string input;
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }
        string ks;
        getline(cin, ks);
        int k = stoi(ks);
        Solution ob;
        vector<int> ans = ob.longestSubarray(arr, k);
        for (auto it : ans) {
            cout << it << " ";
        }
        cout << endl;
        cout << "~" << endl;
    }
    return 0;
}
// } Driver Code Ends