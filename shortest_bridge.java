class Solution {
    class Node {
        int i;
        int j;
        int dist;

        Node(int i, int j, int dist) {
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        boolean visited[][] = new boolean[n][n];
        int arr[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        Queue<Node> qu = new LinkedList<>();
        boolean isTrue = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !isTrue) {
                    isTrue = true;
                    Dfs(grid, arr, i, j, visited, qu);
                }
            }
        }
        int min=Integer.MAX_VALUE;
        while (!qu.isEmpty()) {
            Node node = qu.remove();
            int i = node.i;
            int j = node.j;
            int dist = node.dist;
            for (int k = 0; k < 4; k++) {
                int x = i + arr[k][0];
                int y = j + arr[k][1];
                if (x >= 0 && x < grid.length && y < grid.length && y >= 0 && !visited[x][y]) {
                    visited[x][y]=true;
                    if(grid[x][y]==1){
                        min=Math.min(min,dist+1);
                    }
                    qu.add(new Node(x,y,dist+1));
                }
            }
        }
        return min-1;
    }

    public void Dfs(int grid[][], int arr[][], int i, int j, boolean visited[][], Queue<Node> qu) {
        visited[i][j] = true;
        qu.add(new Node(i, j, 0));
        for (int k = 0; k < 4; k++) {
            int x = i + arr[k][0];
            int y = j + arr[k][1];
            if (x >= 0 && x < grid.length && y < grid.length && y >= 0 && !visited[x][y] && grid[x][y] == 1) {
                Dfs(grid, arr, x, y, visited, qu);
            }
        }
    }
}