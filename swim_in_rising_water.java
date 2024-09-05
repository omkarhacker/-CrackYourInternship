class Solution {
    class Node {
        int i;
        int j;
        int val;

        Node(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dist[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = grid[0][0];
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        int arr[][] = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
        pq.add(new Node(0, 0, grid[0][0]));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int i = node.i;
            int j = node.j;
            int a = node.val;
            if (i == n - 1 && j == m - 1) {
                return a;
            }
            for (int k = 0; k < 4; k++) {
                int x = i + arr[k][0];
                int y = j + arr[k][1];
                if (x >= 0 && y >= 0 && x < n && y < m) {
                    int val = Math.max(a, grid[x][y]);
                    if (val < dist[x][y]) {
                        dist[x][y] = val;
                        pq.add(new Node(x, y, val));
                    }
                }
            }
        }
        return -1;
    }
}s