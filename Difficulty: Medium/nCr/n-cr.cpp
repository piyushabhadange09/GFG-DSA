//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    int nCr(int n, int r) {
        // code here
         long ans = 1l;
        for(int i=0; i<r; i++){
            ans = ans*(n-i);
            ans = ans/(i+1);
        }
        return (int) ans;
    }
};


//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, r;
        cin >> n >> r;

        Solution ob;
        cout << ob.nCr(n, r) << endl;

        cout << "~"
             << "\n";
    }
    return 0;
}
// } Driver Code Ends