class Solution {
    class Node {
        int val;
        int cost;

        Node(int val, int cost) {
            this.val = val;
            this.cost = cost;
        }
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int m = edges.length;
        ArrayList<ArrayList<Node>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(new Node(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Node(edges[i][0], edges[i][2]));
        }
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int val = findAns(adj, i, distanceThreshold);
            if (val <= min) {
                min = val;
                ans = i;
            }
        }
        return ans;
    }

    public int findAns(ArrayList<ArrayList<Node>> adj, int j, int u) {
        Queue<Node> qu = new LinkedList<>();
        int dist[] = new int[adj.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[j] = 0;
        qu.add(new Node(j, 0));
        while (!qu.isEmpty()) {
            Node node = qu.remove();
            int val = node.val;
            int cost = node.cost;
            for (int i = 0; i < adj.get(val).size(); i++) {
                Node x = adj.get(val).get(i);
                int val1 = x.val;
                int cost1 = x.cost;
                if (dist[val1] > cost1 + dist[val]) {
                    dist[val1] = cost1 + dist[val];
                    qu.add(new Node(val1, cost1 + dist[val]));
                }
            }
        }
        int count = 0;
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] <= u) {
                count++;
            }
        }
        return count;
    }
}