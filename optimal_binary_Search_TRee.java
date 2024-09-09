class Solution {
    static int optimalSearchTree(int keys[], int freq[], int n) {
        // Create the cumulative frequency (weight) array
        int[][] weight = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            weight[i][i] = freq[i - 1];
            for (int j = i + 1; j <= n; j++) {
                weight[i][j] = weight[i][j - 1] + freq[j - 1];
            }
        }

        // Initialize the matrix to store the costs
        int[][] matrix = new int[n + 1][n + 1];
        
        // Base cases: for trees with one node
        for (int i = 1; i <= n; i++) {
            matrix[i][i] = freq[i - 1];
        }

        // Fill the matrix for larger subtrees (bottom-up approach)
        for (int len = 2; len <= n; len++) { // length of the interval
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                matrix[i][j] = Integer.MAX_VALUE;

                // Find the root that minimizes the cost
                for (int r = i; r <= j; r++) {
                    int cost = ((r > i) ? matrix[i][r - 1] : 0) +
                               ((r < j) ? matrix[r + 1][j] : 0) +
                               weight[i][j];
                    matrix[i][j] = Math.min(matrix[i][j], cost);
                }
            }
        }

        // The result is the minimum cost of building the optimal BST for all keys
        return matrix[1][n];
    }
}
