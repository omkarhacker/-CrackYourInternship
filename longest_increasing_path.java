class Solution {
    class Node {
        int i;
        int j;

        Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int max = Integer.MIN_VALUE;
        int dist[][] = new int[n][m];
        int arr[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, findAns(i, j, matrix, arr, dist));
            }
        }
        return max;
    }

    public int findAns(int i, int j, int matrix[][], int arr[][], int dist[][]) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (dist[i][j] != 0) {
            return dist[i][j];
        }
        int max = 1;
        for (int k = 0; k < 4; k++) {
            int x = i + arr[k][0];
            int y = j + arr[k][1];
            if (x >= 0 && y >= 0 && x < n && y < m && matrix[x][y] > matrix[i][j]) {
                max = Math.max(max, 1 + findAns(x, y, matrix, arr, dist));
            }
        }
        dist[i][j] = max;
        return max;
    }
}