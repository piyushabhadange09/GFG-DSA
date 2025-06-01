class Solution {
    int countPairs(int[][] mat1, int[][] mat2, int x) {
        int n = mat1.length;
        HashSet<Integer> set = new HashSet<>();
        
        // Flatten mat2 into the HashSet
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                set.add(mat2[i][j]);
            }
        }
        
        int count = 0;
        
        // Check if (x - mat1[i][j]) exists in mat2
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (set.contains(x - mat1[i][j])) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
