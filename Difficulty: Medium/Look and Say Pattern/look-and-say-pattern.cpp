//{ Driver Code Starts
// Initial template for C++
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    string countAndSay(int n) {
        // code here
        string prev = "1";
        string next;
        for(int i=2;i<=n;i++){
            int len = prev.length();
            int count = 1;
            for(int j=1;j<len;j++){
                if(prev[j-1]==prev[j]){
                    count++;
                }
                else{
                    next += to_string(count)+prev[j-1];
                    count = 1;
                }
            }
            next += to_string(count)+prev[len-1];
            prev = next;
            next = "";
        }
        return prev;
    }
};


//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        Solution obj;
        cout << obj.countAndSay(n) << endl;

        cout << "~"
             << "\n";
    }
    return 0;
}
// } Driver Code Ends