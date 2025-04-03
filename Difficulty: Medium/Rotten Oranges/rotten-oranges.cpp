//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    int orangesRotting(vector<vector<int>>& mat) {
        // Code here
          int n=mat.size();
        int m=mat[0].size();
        
        queue<pair<pair<int,int>, int>>q;
        vector<vector<int>> vis(n, vector<int>(m, -1));
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==2){
                    q.push({{i,j},0});
                    vis[i][j]=2;
                }
                else{
                    vis[i][j]=0;
                }
            }
        }
        
        int tm=0;
        int drow[]={-1,0,1,0};
        int dcol[]={0,1,0,-1};
        
        while(!q.empty()){
            int r=q.front().first.first;
            int c=q.front().first.second;
            int t=q.front().second;
            q.pop();
            tm=max(tm,t);
            
            for(int i=0;i<4;i++){
                int nrow= r+drow[i];
                int ncol= c+dcol[i];
                
                if(nrow>=0 and nrow<n and
                   ncol>=0 and ncol<m and
                   vis[nrow][ncol] !=2 and mat[nrow][ncol] ==1){
                       q.push({{nrow,ncol},t+1});
                       vis[nrow][ncol]=2;
                   }
            }
            
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j] !=2 and mat[i][j]==1)return -1;
            }
        }
        
        return tm;
    }
};


//{ Driver Code Starts.
int main() {
    int tc;
    cin >> tc;
    while (tc--) {
        int n, m;
        cin >> n >> m;
        vector<vector<int>> mat(n, vector<int>(m, -1));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cin >> mat[i][j];
            }
        }
        Solution obj;
        int ans = obj.orangesRotting(mat);
        cout << ans << "\n";

        cout << "~"
             << "\n";
    }
    return 0;
}
// } Driver Code Ends