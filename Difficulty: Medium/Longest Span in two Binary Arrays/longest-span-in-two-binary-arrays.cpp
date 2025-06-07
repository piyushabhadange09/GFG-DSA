class Solution {
  public:
    int longestCommonSum(vector<int> &a1, vector<int> &a2) {
        // Code here.
        std::unordered_map<int, int> map;

        // Initialize the map: A sum of 0 is found before any elements are processed (at index -1).
        // This is crucial for handling subarrays starting from index 0.
        map[0] = -1;

        int sum = 0; // Stores the running sum of (a1[i] - a2[i])
        int ans = 0; // Stores the maximum length found so far

        // Iterate through the arrays
        for (int i = 0; i < a1.size(); ++i) {
            // Calculate the difference between current elements and add to the running sum
            sum += (a1[i] - a2[i]);

            // If the current sum is not already in the map, store its first occurrence (current index i).
            // If it is already in the map, we don't update it, as we need the *first* occurrence
            // to maximize the length of the subarray.
            if (map.find(sum) == map.end()) {
                map[sum] = i;
            }

            // If the current sum *is* in the map (meaning we've encountered this sum before),
            // it indicates that the subarray between the *first* occurrence of this sum
            // and the *current* index has a sum of 0 (for the difference array).
            // Calculate the length of this subarray and update the maximum length (ans).
            ans = std::max(ans, i - map[sum]);
        }

        return ans;
    }
};