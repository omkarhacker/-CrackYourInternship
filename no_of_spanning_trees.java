class Solution {
    public static int countSpanningTrees(int[][] graph,int n,int m) {
        // code here
        HashMap<Integer,Integer>hm=new HashMap<>();
        int matrix[][]=new int[n][n];
        for(int i=0;i<m;i++){
            matrix[graph[i][0]][graph[i][1]]=-1;
            matrix[graph[i][1]][graph[i][0]]=-1;
            hm.put(graph[i][0],hm.getOrDefault(graph[i][0],0)+1);
            hm.put(graph[i][1],hm.getOrDefault(graph[i][1],0)+1);
        }
        
        for(int i=0;i<n;i++){
            if(hm.containsKey(i)){
                 matrix[i][i]=hm.get(i);
            }
        }
        int[][] reducedMatrix = getMinor(matrix, 0, 0);

        // Calculate the determinant of the reduced matrix
        int det = determinant(reducedMatrix);
        return det;
    }
    public static int[][] getMinor(int[][] matrix, int row, int col) {
        int n = matrix.length;
        int[][] minor = new int[n - 1][n - 1];
        int r = 0;
        for (int i = 0; i < n; i++) {
            if (i == row) continue;
            int c = 0;
            for (int j = 0; j < n; j++) {
                if (j == col) continue;
                minor[r][c++] = matrix[i][j];
            }
            r++;
        }
        return minor;
    }
    public static int determinant(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0];
        }
        if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }
        int det = 0;
        for (int p = 0; p < n; p++) {
            det += (p % 2 == 0 ? 1 : -1) * matrix[0][p] * determinant(getMinor(matrix, 0, p));
        }
        return det;
    }
}
        