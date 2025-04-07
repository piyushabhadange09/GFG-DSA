//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    bool isCyclic(int V, vector<vector<int>> &edges) {
        // code here
         vector<vector<int>> adj(V);
    
    // Convert edge list to adjacency list
    for (auto &edge : edges) {
        int u = edge[0];
        int v = edge[1];
        adj[u].push_back(v);
    }

    vector<int> indegree(V, 0);

    // Compute in-degrees
    for (int i = 0; i < V; i++) {
        for (int neighbor : adj[i]) {
            indegree[neighbor]++;
        }
    }

    queue<int> q;

    // Enqueue all nodes with in-degree 0
    for (int i = 0; i < V; i++) {
        if (indegree[i] == 0) {
            q.push(i);
        }
    }

    int count = 0;

    // Kahn's algorithm
    while (!q.empty()) {
        int node = q.front();
        q.pop();
        count++;

        for (int neighbor : adj[node]) {
            indegree[neighbor]--;
            if (indegree[neighbor] == 0) {
                q.push(neighbor);
            }
        }
    }

    // If count != V, a cycle exists
    return count != V;
    }
};


//{ Driver Code Starts.

int main() {
    int tc;
    cin >> tc;
    cin.ignore();
    while (tc--) {
        int V, E;
        cin >> V >> E;
        cin.ignore();
        vector<vector<int>> edges;
        for (int i = 1; i <= E; i++) {
            int u, v;
            cin >> u >> v;
            edges.push_back({u, v});
        }

        Solution obj;
        bool ans = obj.isCyclic(V, edges);
        if (ans)
            cout << "true\n";
        else
            cout << "false\n";
    }
    return 0;
}
// } Driver Code Ends