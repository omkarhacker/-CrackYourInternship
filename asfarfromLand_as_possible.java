class Solution {
    class Node {
        int val1;
        int val2;

        Node(int val1, int val2) {
            this.val1 = val1;
            this.val2 = val2;
        }
    }

    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean find1=false;
        boolean find0=false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    find0=true;
                }
                if(grid[i][j]==1){
                    find1=true;
                }
            }
        }
        if(!find0 || !find1){
            return -1;
        }
        int dist[][] = new int[n][m];
        for (int k = 0; k < n; k++) {
            Arrays.fill(dist[k], Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    findAns(grid, i, j, dist);
                }
            }
        }
        int max = 0;
        for (int k = 0; k < n; k++) {
            for (int l = 0; l < m; l++) {
                if (dist[k][l] != Integer.MAX_VALUE) {
                    max = Math.max(max, dist[k][l]);
                }
            }
        }
        return max;
    }

    public void findAns(int grid[][], int i, int j, int dist[][]) {
        int n = grid.length;
        int m = grid[0].length;

        int arr[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        Queue<Node> qu = new LinkedList<>();
        qu.add(new Node(i, j));
        dist[i][j] = 0;
        while (!qu.isEmpty()) {
            Node node = qu.remove();
            int val1 = node.val1;
            int val2 = node.val2;
            for (int k = 0; k < 4; k++) {
                int x = val1 + arr[k][0];
                int y = val2 + arr[k][1];
                if (x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == 0) {
                    if (dist[x][y] > 1 + dist[val1][val2]) {
                        dist[x][y] = 1 + dist[val1][val2];
                        qu.add(new Node(x, y));
                    }
                }
            }
        }

    }
}