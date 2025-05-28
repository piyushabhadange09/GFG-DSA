class Solution {
  public:
    bool ValidCorner(vector<vector<int>>& matrix) {
        int m = matrix.size();
        int n = matrix[0].size();

        // Map to track column pairs that have already occurred with 1s in previous rows
        unordered_map<int, unordered_set<int>> dp;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int j2 = j + 1; j2 < n; j2++) {
                    // Check for pair of 1s in same row
                    if (matrix[i][j] == 1 && matrix[i][j2] == 1) {
                        // If this column pair was seen before, a rectangle is formed
                        if (dp[j].find(j2) != dp[j].end()) {
                            return true;
                        }
                        dp[j].insert(j2);  // Mark the pair as seen
                    }
                }
            }
        }

        return false;  // No rectangle found
    }
};
