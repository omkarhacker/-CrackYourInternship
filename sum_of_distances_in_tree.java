class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int sum0 = findZero(adj, n);
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        findChild(dp, adj, 0, -1);
        for (int i = 0; i < n; i++) {
            System.out.println(dp[i]);
        }
        int ans[] = new int[n];
        ans[0] = sum0;
        boolean visited[] = new boolean[n];
        Queue<Integer> qu = new LinkedList<>();
        qu.add(0);
        visited[0] = true;
        while (!qu.isEmpty()) {
            int val = qu.remove();
            for (int i = 0; i < adj.get(val).size(); i++) {
                int val1 = adj.get(val).get(i);
                if (visited[val1] == false) {
                    visited[val1]=true;
                    ans[val1] = ans[val] + n - 2 * dp[val1];
                    qu.add(val1);
                }
            }
        }
        return ans;
    }

    public int findZero(ArrayList<ArrayList<Integer>> adj, int n) {
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Integer> qu = new LinkedList<>();
        qu.add(0);
        dist[0] = 0;
        while (!qu.isEmpty()) {
            int val = qu.remove();
            for (int i = 0; i < adj.get(val).size(); i++) {
                int val1 = adj.get(val).get(i);
                if (dist[val1] > 1 + dist[val]) {
                    dist[val1] = 1 + dist[val];
                    qu.add(val1);
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + dist[i];
        }
        return sum;
    }

    public int findChild(int dp[], ArrayList<ArrayList<Integer>> adj, int j, int parent) {
        // if (adj.get(j).size() == 0) {
        // return 1;
        // }
        if (dp[j] != -1) {
            return dp[j];
        }
        int sum = 0;
        for (int i = 0; i < adj.get(j).size(); i++) {
            int val = adj.get(j).get(i);
            if (val != parent) {
                sum = sum + findChild(dp, adj, val, j);
            }
        }
        return dp[j] = sum + 1;
    }
}