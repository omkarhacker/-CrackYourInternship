class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int parent[] = new int[n+1];
        int rank[] = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        int ans[] = new int[2];
        for (int i = 0; i < n; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            int val1 = findParent(parent, x);
            int val2 = findParent(parent, y);
            if (val1 == val2) {
                ans[0] = x;
                ans[1] = y;
                break;
            }
            else{
                findUnion(parent,rank,x,y);
            }
        }
        return ans;
    }

    public int findParent(int parent[], int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = findParent(parent, parent[i]);
    }

    public void findUnion(int parent[], int rank[], int val1, int val2) {
        int x = findParent(parent, val1);
        int y = findParent(parent, val2);
        if (x == y) {
            return;
        }
        if (rank[x] == rank[y]) {
            rank[x]++;
            parent[y] = x;
        } else if (rank[x] > rank[y]) {
            parent[x] = y;
        } else {
            parent[x] = y;
        }
    }
}